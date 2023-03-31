package com.example.pokemonapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.models.CoinDetails
import com.example.pokemonapp.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(private val repository: CoinRepository):ViewModel() {

    private val _coinDetailLiveData = MutableLiveData<CoinDetails>()
    val coinDetailLiveData : LiveData<CoinDetails>
        get() = repository.coinDetails

    fun getItemById(id: String) {
        viewModelScope.launch {
           repository.getCoinById(id)
           // _coinDetailLiveData.postValue(retrievedItem)
        }
    }


}