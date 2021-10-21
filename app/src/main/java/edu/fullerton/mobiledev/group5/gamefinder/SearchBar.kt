package edu.fullerton.mobiledev.group5.gamefinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import edu.fullerton.mobiledev.group5.gamefinder.databinding.ActivityMainBinding


class SearchBar : AppCompatActivity() {

        lateinit var binding : ActivityMainBinding


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val user = arrayOf("Shooter","Fighting","Adventure","Puzzle","Strategy")

            val userAdapter : ArrayAdapter<String> = ArrayAdapter(
                this,android.R.layout.simple_list_item_1,
                user
            )

            binding.userList.adapter = userAdapter;

            binding.searchView.setOnQueryTextListener(object  : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    binding.searchView.clearFocus()
                    if (user.contains(query)){

                        userAdapter.filter.filter(query)

                    }
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    userAdapter.filter.filter(newText)
                    return false
                }


            })

        }
    }
}