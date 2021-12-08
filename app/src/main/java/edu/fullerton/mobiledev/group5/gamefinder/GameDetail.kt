package edu.fullerton.mobiledev.group5.gamefinder

import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import edu.fullerton.mobiledev.group5.gamefinder.databinding.FragmentGameDetailBinding
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import android.view.MenuInflater
import android.view.Menu
import androidx.core.text.HtmlCompat

class GameDetail : Fragment() {
    private val args: GameDetailArgs by navArgs()
    private lateinit var info: GameInformation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val act: AppCompatActivity = activity as AppCompatActivity
        act.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.detail_app_bar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)

        val binding = FragmentGameDetailBinding.inflate(
            layoutInflater, container, false)
        binding.gameTitle.text = args.gameTitle
        Glide.with(binding.root.context).load(args.imageUrl).into(binding.gameArt)
        loadDetails(args.id, binding)
        binding.gameDescription.movementMethod = ScrollingMovementMethod()
        return binding.root
    }

    fun onCreateOptionsMenu(): Boolean {
        return true
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                return true
            }

            R.id.action_favorite -> {
                return true
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }

    private fun loadDetails(id: Int, binding: FragmentGameDetailBinding)
    {
        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl(VideoGameDatabaseService.API_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val service = retrofit.create(VideoGameDatabaseService::class.java)

        service.getDetails(id).enqueue(object : Callback<GameInformation> {
            override fun onResponse(call: Call<GameInformation>, response: Response<GameInformation>) {
                if (response.isSuccessful) {
                    info = response.body()!!
                    binding.gameDescription.text = Html.fromHtml(info.description, HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH)
                }
            }

            override fun onFailure(call: Call<GameInformation>, t: Throwable) {
                t.printStackTrace()
                info = GameInformation(0, args.gameTitle, "", "", 0, "", 0)
            }
        })
    }
}