package com.example.pokemonapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.models.Coin
import com.example.pokemonapp.models.CoinDetails
import com.example.pokemonapp.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: CoinRepository) : ViewModel() {

    val coinsLiveData: LiveData<List<Coin>>
    get() = repository.coins

    init {
        viewModelScope.launch {
            repository.getCoin()

        }
    }

}