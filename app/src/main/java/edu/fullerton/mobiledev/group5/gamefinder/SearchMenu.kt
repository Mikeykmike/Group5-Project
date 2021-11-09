package edu.fullerton.mobiledev.group5.gamefinder

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class SearchMenu : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerAdapter

    private var genreList = mutableListOf<String>()
    private var displayList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        genreList.add("Fighting")
        genreList.add("FPS")
        genreList.add("Puzzle")
        genreList.add("Adventure")

        displayList.addAll(genreList)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerAdapter = RecyclerAdapter(displayList)

        recyclerView.adapter = recyclerAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        var item: MenuItem = menu!!.findItem(R.id.action_search)

        if(item!=null){
            var searchView = item.actionView as SearchView

            searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()) {
                        displayList.clear()
                        var search = newText.lowercase(Locale.getDefault())

                        for (genre in genreList) {
                            if (genre.lowercase(Locale.getDefault()).contains(search)) {
                                displayList.add(genre)
                            }
                            recyclerView.adapter!!.notifyDataSetChanged()
                        }

                    }else{
                        displayList.clear()
                        displayList.addAll(genreList)
                    }

                }

            }

        }

            return super.onCreateOptionsMenu(menu)
    }

}