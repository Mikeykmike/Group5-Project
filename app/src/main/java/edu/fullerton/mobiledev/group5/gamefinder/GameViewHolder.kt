package edu.fullerton.mobiledev.group5.gamefinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
   val image: ImageView = view.findViewById(R.id.imageView)
    val text: TextView = view.findViewById(R.id.textView)
}

class GameViewAdapter : RecyclerView.Adapter<GameViewHolder>()
{
   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder =
        GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.game_image_widget, parent, false))

   override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.text.text = "Game $position"
    }

    override fun getItemCount(): Int = 100
}