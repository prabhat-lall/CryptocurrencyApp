package com.example.pokemonapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R
import com.example.pokemonapp.models.TeamMember

class TeamAdapter(private val teamMemberList : List<TeamMember>): RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.team_item,parent,false)
        return TeamViewHolder(view)
    }

    override fun getItemCount(): Int {
        return teamMemberList.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val item  = teamMemberList[position]
        holder.name.text = item.name
        holder.pos.text = item.position
    }

    class TeamViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val name :TextView = itemView.findViewById(R.id.tv_team_member_name)
        val pos :TextView =itemView.findViewById(R.id.tv_team_member_position)
    }
}