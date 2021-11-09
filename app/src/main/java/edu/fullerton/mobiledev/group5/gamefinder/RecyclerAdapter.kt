package edu.fullerton.mobiledev.group5.gamefinder


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import edu.fullerton.mobiledev.group5.gamefinder.RecyclerAdapter.*

class RecyclerAdapter(genreList: MutableList<String>): RecyclerView.Adapter<ViewHolder>() {

    private var genre: MutableList<String> = genreList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardlayout, parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = genre[position]
    }

    override fun getItemCount(): Int {
        return genre.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
      var itemImage: ImageView
      var itemTitle: TextView

        init{
            itemImage= itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)

            itemView.setOnClickListener{
                val position: Int = bindingAdapterPosition
                Toast.makeText(itemView.context, "${genre[position]}", Toast.LENGTH_LONG).show()
            }


        }
    }
}