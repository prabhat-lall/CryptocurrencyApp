package com.example.pokemonapp.retrofit

import com.example.pokemonapp.models.Coin
import com.example.pokemonapp.models.CoinDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinAPI {

    @GET("v1/coins")
    suspend fun getCoin() : Response<List<Coin>>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinDetail(@Path("coinId")coinId:String) : Response<CoinDetails>
}