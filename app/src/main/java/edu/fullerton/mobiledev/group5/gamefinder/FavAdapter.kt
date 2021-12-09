package edu.fullerton.mobiledev.group5.gamefinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fav_rows.view.*


class FavAdapter: RecyclerView.Adapter<FavAdapter.MyViewHolder>() {

    private var favList = emptyList<FavEntity>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fav_rows,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = favList[position]
        holder.itemView.gameTitle.text = currentItem.gameTitle
    }

    fun setData(favEntity: List<FavEntity>){
        this.favList=favEntity
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return favList.size
    }
}

