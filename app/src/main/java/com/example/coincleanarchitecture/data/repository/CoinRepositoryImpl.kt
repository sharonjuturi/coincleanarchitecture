package com.example.coincleanarchitecture.data.repository

import com.example.coincleanarchitecture.data.remote.CoinApiService
import com.example.coincleanarchitecture.data.remote.dto.CoinDto
import com.example.coincleanarchitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApiService
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }
}