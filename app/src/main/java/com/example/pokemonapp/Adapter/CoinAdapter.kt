package com.example.pokemonapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R
import com.example.pokemonapp.models.Coin

class CoinAdapter(private val coinList: List<Coin>) :
    RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    var onItemClick: ((Coin) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coin_item, parent, false)
        return CoinViewHolder(view)
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val item = coinList[position]
        holder.tvCoinName.text = item.name
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(item)
        }
    }

    class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCoinName: TextView = itemView.findViewById(R.id.tv_coin_name)
    }

}