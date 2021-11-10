package edu.fullerton.mobiledev.group5.gamefinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationBarView
import edu.fullerton.mobiledev.group5.gamefinder.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_game_browser.*
import kotlinx.android.synthetic.main.fragment_search.*

class MainActivity : AppCompatActivity() {
    private val favorites = favorites()
    private val search = search()
    private val trending = trending()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        bottomNavigationBar.setOnItemSelectedListener{
            when(it.itemId){
                R.id.favorites -> replaceFragment(favorites)
                R.id.search -> replaceFragment(search)
                R.id.trending -> replaceFragment(trending)
            }
            true
        }
//        val controller = findNavController(R.id.navigationController)
//        NavigationUI.setupActionBarWithNavController(this, controller)
//
//        mainBinding.bottomNavigationBar.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener(
//            fun(it: MenuItem) : Boolean {
//                when (it.itemId)
//                {
//                    R.id.trending -> {
//                        controller.navigate(R.id.gameDetail)
//                        return true
//                    }
//
//                }
//                return true
//            }))

    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragContainer, fragment)
            transaction.commit()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val controller = findNavController(R.id.navigationController)
        return controller.navigateUp()
    }
}