package com.example.coincleanarchitecture.presentation

import com.example.coincleanarchitecture.domain.model.Coin
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
