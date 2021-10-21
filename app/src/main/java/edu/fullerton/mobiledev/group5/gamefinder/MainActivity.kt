package edu.fullerton.mobiledev.group5.gamefinder

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import edu.fullerton.mobiledev.group5.gamefinder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val favFragment = Favorites()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.recyclerView.layoutManager = GridLayoutManager(this,4)
        mainBinding.recyclerView.adapter = GameViewAdapter()
    }

    private fun switchActivity(fragment: Fragment){
        if(fragment != null) {
            val transaction= supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragContainer,fragment)
            transaction.commit()
        }
    }

}