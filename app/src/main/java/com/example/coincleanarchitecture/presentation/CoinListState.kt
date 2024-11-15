package com.example.coinscleanarchiture.presentation

import com.example.coincleanarchitecture.domain.model.Coin
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
