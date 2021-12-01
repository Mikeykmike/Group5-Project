package edu.fullerton.mobiledev.group5.gamefinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.view.Menu
import edu.fullerton.mobiledev.group5.gamefinder.databinding.ActivityMainBinding
import edu.fullerton.mobiledev.group5.gamefinder.databinding.FragmentGameDetailBinding
import android.R.attr.data
import android.R.attr
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide


class GameDetail : Fragment() {
    private val args: GameDetailArgs by navArgs<GameDetailArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val act: AppCompatActivity = activity as AppCompatActivity
        act.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGameDetailBinding.inflate(
            layoutInflater, container, false)
        binding.gameTitle.text = args.gameTitle
        Glide.with(binding.root.context).load(args.imageUrl).into(binding.gameArt)
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
        }
        return super.onOptionsItemSelected(menuItem)
    }
}