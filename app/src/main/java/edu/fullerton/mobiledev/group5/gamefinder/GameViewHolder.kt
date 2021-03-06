package edu.fullerton.mobiledev.group5.gamefinder

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GameViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
    private val imageView: ImageView = view.findViewById(R.id.imageView)
    val textView: TextView = view.findViewById(R.id.textView)
    var id: Int = 0

    var imageUrl: String = ""
        set(value) {
            if (value.isNotEmpty()) {
                Glide.with(itemView.context).load(value).centerCrop().apply(RequestOptions().override(200, 200)).into(imageView)
            }
            field = value
        }

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val args = GameBrowserDirections.actionGameBrowserToGameDetail()
        args.gameTitle = textView.text.toString()
        args.imageUrl = imageUrl
        args.id = id
        findNavController(view).navigate(args)
    }
}

class GameViewAdapter : RecyclerView.Adapter<GameViewHolder>() {
    companion object {
        var gameList: GameList = GameList(0, "", "", listOf())
    }

    init {
        // Only refresh the game list the first time
        if (gameList.count == 0) {
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder()
                .baseUrl(VideoGameDatabaseService.API_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            val service = retrofit.create(VideoGameDatabaseService::class.java)

            service.getGames().enqueue(object : Callback<GameList> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(call: Call<GameList>, response: Response<GameList>) {
                    if (response.isSuccessful) {
                        gameList = response.body() ?: gameList
                        notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<GameList>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder =
        GameViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.game_image_widget, parent, false)
        )

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.id = gameList.results[position].id
        holder.textView.text = gameList.results[position].name
        val url = gameList.results[position].imageUrl
        holder.imageUrl = url ?: holder.imageUrl
    }

    override fun getItemCount(): Int = gameList.results.size
}