package com.example.pokemonapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pokemonapp.Adapter.TagAdapter
import com.example.pokemonapp.Adapter.TeamAdapter
import com.example.pokemonapp.viewmodel.CoinDetailViewModel
import com.example.pokemonapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.ViewModelLifecycle

@AndroidEntryPoint
class CoinDetailActivity : AppCompatActivity() {

    lateinit var coinDetailViewModel: CoinDetailViewModel
    private val textView: TextView
        get() = findViewById(R.id.tv_coin)

    private val rvTags: RecyclerView
        get() = findViewById(R.id.tagsRecyclerView)

    private val tvName: TextView
        get() = findViewById(R.id.tv_coin)
    private val tvDiscription: TextView
        get() = findViewById(R.id.tv_coin_description)

    private val rvTeam: RecyclerView
        get() = findViewById(R.id.rv_team_member)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)
        coinDetailViewModel = ViewModelProvider(this).get(CoinDetailViewModel::class.java)

        val coinId: String? = intent.getStringExtra("coinId")
        Log.d("_prabhat", coinId.toString())
        coinDetailViewModel.getItemById(coinId!!)

        coinDetailViewModel.coinDetailLiveData.observe(this, Observer {
            //Log.d("_prabhat","$it")
            val tagAdapter = TagAdapter(it.tags)
            rvTags.layoutManager = StaggeredGridLayoutManager(3,LinearLayoutManager.HORIZONTAL)
            rvTags.adapter = tagAdapter
            tvDiscription.text = it.description
            tvName.text = it.name
            val teamAdapter = TeamAdapter(it.team)
            rvTeam.adapter = teamAdapter
            rvTeam.layoutManager = LinearLayoutManager(this)

        })


    }
}