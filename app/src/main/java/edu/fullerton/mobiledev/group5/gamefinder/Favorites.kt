package edu.fullerton.mobiledev.group5.gamefinder

import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import android.view.*
import android.widget.ListAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.findFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import edu.fullerton.mobiledev.group5.gamefinder.databinding.FavRowsBinding
import edu.fullerton.mobiledev.group5.gamefinder.databinding.FragmentFavoritesBinding
import edu.fullerton.mobiledev.group5.gamefinder.databinding.FragmentGameDetailBinding
import kotlinx.android.synthetic.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_favorites.view.*

class Favorites : Fragment() {

    private val args: GameDetailArgs by navArgs()
    private lateinit var mFavViewModel: FavViewModel

     override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
       savedInstanceState: Bundle?
      ): View? {

         val view = inflater.inflate(R.layout.fragment_favorites,container,false)

         val adapter = FavAdapter()
         val recyclerview = view.favoritesRecycler
         recyclerview.adapter = adapter
         recyclerview.layoutManager = LinearLayoutManager(requireContext())

         mFavViewModel= ViewModelProvider(this).get(FavViewModel::class.java)
         mFavViewModel.readAllData.observe(this, Observer { favoriteItems ->
            adapter.setData(favoriteItems)
         })
         return view
     }

/* private fun loadDetails(id: Int, binding: FragmentGameDetailBinding)
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
  }*/
}