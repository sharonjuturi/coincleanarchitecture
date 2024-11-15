package com.example.coinscleanarchiture.data.repository

import com.example.coincleanarchitecture.data.remote.CoinDto
import com.example.coinscleanarchiture.data.remote.CoinApiService
import com.example.coinscleanarchiture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApiService
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }
}