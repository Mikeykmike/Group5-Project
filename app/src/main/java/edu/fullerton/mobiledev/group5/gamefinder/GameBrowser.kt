package edu.fullerton.mobiledev.group5.gamefinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import edu.fullerton.mobiledev.group5.gamefinder.databinding.ActivityMainBinding
import edu.fullerton.mobiledev.group5.gamefinder.databinding.FragmentGameBrowserBinding

class GameBrowser : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val mainBinding = FragmentGameBrowserBinding.inflate(layoutInflater)

        mainBinding.recyclerView.layoutManager = GridLayoutManager(activity,4)
        mainBinding.recyclerView.adapter = GameViewAdapter()

        return mainBinding.root
    }
}