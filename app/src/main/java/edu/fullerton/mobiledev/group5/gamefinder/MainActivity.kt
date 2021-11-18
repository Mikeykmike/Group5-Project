package edu.fullerton.mobiledev.group5.gamefinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import edu.fullerton.mobiledev.group5.gamefinder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val favorites = Favorites()
    private val search = Search()
    private val trending = Trending()
    private val options = Options()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val navFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val controller = navFragment.navController
        val config = AppBarConfiguration(controller.graph)
        setupActionBarWithNavController(controller, config)

        mainBinding.bottomNavigationBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeNav -> controller.navigate(R.id.gameBrowser)
                R.id.favNav -> controller.navigate(R.id.favorites)
                R.id.searchNav -> controller.navigate(R.id.search)
                R.id.trendNav -> controller.navigate(R.id.trending)
                R.id.optionsNav-> controller.navigate(R.id.options)
            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val controller = navFragment.navController
        controller.navigate(R.id.gameBrowser)

        mainBinding.bottomNavigationBar.selectedItemId = 0
        return true
    }
}