package edu.fullerton.mobiledev.group5.gamefinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationBarView
import edu.fullerton.mobiledev.group5.gamefinder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

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

    override fun onSupportNavigateUp(): Boolean {
        val controller = findNavController(R.id.navigationController)
        return controller.navigateUp()
    }
}