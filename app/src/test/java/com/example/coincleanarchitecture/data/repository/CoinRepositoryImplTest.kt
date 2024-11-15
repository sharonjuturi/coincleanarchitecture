package com.example.coincleanarchitecture.data.repository

import com.example.coincleanarchitecture.data.remote.CoinDto
import com.example.coinscleanarchiture.data.remote.CoinApiService
import com.example.coinscleanarchiture.data.repository.CoinRepositoryImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class CoinRepositoryImplTest{
    private lateinit var coinRepository: CoinRepositoryImpl
    private val coinApiService: CoinApiService = mock()
    @Before
    fun setup() {
        coinRepository = CoinRepositoryImpl(coinApiService)
    }
    @Test
    fun test_coins_success() = runTest {
        val coins = getCoinsData()
        whenever(coinApiService.getCoins()).thenReturn(coins)
        val result = coinRepository.getCoins()
        assertEquals(getCoinsData(), result)
    }
    private fun getCoinsData(): List<CoinDto> {
        return listOf(
            CoinDto(
                id = "1",
                isActive = true,
                isNew = true,
                name = "BItCoin",
                rank = 1,
                symbol = "BTC",
                type = "digital"
            ),
        )
    }
}