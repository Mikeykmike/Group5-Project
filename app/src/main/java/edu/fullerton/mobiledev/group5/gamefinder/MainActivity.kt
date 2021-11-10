package edu.fullerton.mobiledev.group5.gamefinder

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.navigation.NavigationBarView
import edu.fullerton.mobiledev.group5.gamefinder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    private val favorites = favorites()
    private val search = search()
    private val trending = trending()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.bottomNavigationBar.setOnItemSelectedListener{
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
        onBackPressed()
        return true
    }
}