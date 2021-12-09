package edu.fullerton.mobiledev.group5.gamefinder

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import edu.fullerton.mobiledev.group5.gamefinder.databinding.FragmentGameBrowserBinding

class GameBrowser : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)
        val mainBinding = FragmentGameBrowserBinding.inflate(layoutInflater)

        mainBinding.recyclerView.layoutManager = GridLayoutManager(activity,4)
        mainBinding.recyclerView.adapter = GameViewAdapter()

        return mainBinding.root
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.browser_app_bar, menu)
//        super.onCreateOptionsMenu(menu, inflater)
//    }

//    fun onCreateOptionsMenu(): Boolean {
//        return true
//    }
//
//    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
//        when (menuItem.itemId) {
//            R.id.action_login -> {
//                val args = GameBrowserDirections.actionGameBrowserToLoginFragment()
//                NavHostFragment.findNavController(this).navigate(args)
//            }
//            R.id.action_register -> {
//                val args = GameBrowserDirections.actionGameBrowserToRegisterFragment()
//                NavHostFragment.findNavController(this).navigate(args)
//            }
//        }
//        return super.onOptionsItemSelected(menuItem)
//    }

}

