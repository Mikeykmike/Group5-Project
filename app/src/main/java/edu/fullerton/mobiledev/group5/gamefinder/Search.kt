package edu.fullerton.mobiledev.group5.gamefinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Search : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerAdapter

    private var genreList = mutableListOf<String>()
    private var displayList = mutableListOf<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val searchView = inflater.inflate(R.layout.fragment_search, container, false)


        genreList.add("Fighting")
        genreList.add("FPS")
        genreList.add("Puzzle")
        genreList.add("Adventure")
        genreList.add("Shooter")
        genreList.add("Horror")
        genreList.add("Action")
        genreList.add("RPG")
        genreList.add("Strategy")
        genreList.add("Board Game")
        genreList.add("Racing")
        genreList.add("Educational")
        genreList.add("Music")
        genreList.add("Family")
        genreList.add("Word")
        genreList.add("Trivia")

        displayList.addAll(genreList)

        recyclerView = searchView.findViewById(R.id.recyclerView)
        recyclerAdapter = RecyclerAdapter(displayList)

        recyclerView.adapter = recyclerAdapter


        return searchView
    }
}