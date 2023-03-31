package com.example.pokemonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.Adapter.CoinAdapter
import com.example.pokemonapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private val recyclerView: RecyclerView
        get() = findViewById(R.id.recyclerView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.coinsLiveData.observe(this, Observer {
            recyclerView.layoutManager = LinearLayoutManager(this)
            val adapter = CoinAdapter(it)
            recyclerView.adapter = adapter

            adapter.onItemClick = { it ->
                val intent = Intent(this, CoinDetailActivity::class.java)
                intent.putExtra("coinId", it.id)
                Toast.makeText(this, it.id, Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        })


    }
}