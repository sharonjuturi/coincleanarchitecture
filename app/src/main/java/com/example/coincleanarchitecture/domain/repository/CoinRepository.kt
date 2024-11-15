package com.example.coinscleanarchiture.domain.repository

import com.example.coincleanarchitecture.data.remote.CoinDto


interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
}