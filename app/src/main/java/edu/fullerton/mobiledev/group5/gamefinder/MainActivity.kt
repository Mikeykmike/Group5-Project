package edu.fullerton.mobiledev.group5.gamefinder

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.MenuItem
import android.view.View
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val navFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val controller = navFragment.navController
        val config = AppBarConfiguration(controller.graph)
        setupActionBarWithNavController(controller, config)
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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}