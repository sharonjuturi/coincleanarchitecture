package com.example.coincleanarchitecture.domain.repository

import com.example.coincleanarchitecture.data.remote.dto.CoinDto


interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
}