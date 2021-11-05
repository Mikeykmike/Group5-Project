package edu.fullerton.mobiledev.group5.gamefinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import edu.fullerton.mobiledev.group5.gamefinder.databinding.ActivityMainBinding
import edu.fullerton.mobiledev.group5.gamefinder.databinding.FragmentGameBrowserBinding
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GameBrowser : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val mainBinding = FragmentGameBrowserBinding.inflate(layoutInflater)

        mainBinding.recyclerView.layoutManager = GridLayoutManager(activity,4)
        mainBinding.recyclerView.adapter = GameViewAdapter()

        return mainBinding.root
    }

//    fun onGameClicked(index: Int) {
//        findNavController().navigate(R.id.gameDetail)
//    }
}

