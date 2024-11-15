package com.example.coincleanarchitecture.data.remote

import com.example.coincleanarchitecture.data.remote.dto.CoinDto
import retrofit2.http.GET

interface CoinApiService {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>
}