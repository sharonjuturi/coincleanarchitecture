package com.example.coincleanarchitecture.domain.use_cases

import com.example.coincleanarchitecture.data.remote.CoinDto
import com.example.coincleanarchitecture.data.remote.toCoin
import com.example.coinscleanarchiture.domain.repository.CoinRepository
import com.example.coinscleanarchiture.domain.use_cases.GetCoinUseCase
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class GetCoinUseCaseTest{
    private val coinRepository: CoinRepository = mock()
    @Test
    fun test_success() = runTest {
        whenever(coinRepository.getCoins()).thenReturn(getCoinsData())

        val useCase = GetCoinUseCase(coinRepository)
        val responce = useCase.invoke()
        assertEquals(getCoinsData().map { it.toCoin() }, responce.last().data)
    }
    @Test
    fun test_error() = runTest {
        whenever(coinRepository.getCoins()).thenThrow(RuntimeException("error"))
        val result = GetCoinUseCase(coinRepository).invoke().last()
        assertEquals("error", result.message)
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