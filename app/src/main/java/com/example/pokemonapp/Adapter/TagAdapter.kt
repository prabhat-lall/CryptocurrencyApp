package com.example.pokemonapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R
import com.example.pokemonapp.models.Tag

class TagAdapter(private val tagList: List<Tag>): RecyclerView.Adapter<TagAdapter.TagViewHolder>() {



    class TagViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tagName :TextView = itemView.findViewById(R.id.tv_tag_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tag_item,parent,false)
        return TagViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tagList.size
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        val item = tagList[position]
        holder.tagName.text = item.name
    }
}