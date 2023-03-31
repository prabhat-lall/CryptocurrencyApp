package com.example.pokemonapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokemonapp.models.Coin
import com.example.pokemonapp.models.CoinDetails
import com.example.pokemonapp.retrofit.CoinAPI
import javax.inject.Inject


class CoinRepository @Inject constructor( private val coinApi : CoinAPI ) {

    private val _coins = MutableLiveData<List<Coin>>()
    val coins : LiveData<List<Coin>>
    get() = _coins

    private val _coinDetails = MutableLiveData<CoinDetails>()
    val coinDetails : LiveData<CoinDetails>
    get() = _coinDetails

    suspend fun getCoin(){
        val result = coinApi.getCoin()
        if(result.isSuccessful && result.body()!=null) {
            _coins.postValue(result.body())
        }
    }

    suspend fun getCoinById(coinId:String){
        val result = coinApi.getCoinDetail(coinId)
        if(result.isSuccessful && result.body()!=null){
            _coinDetails.postValue(result.body())
        }

    }

}