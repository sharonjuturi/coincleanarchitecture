package com.example.coincleanarchitecture.presentation

import com.example.coincleanarchitecture.common.Resource
import com.example.coincleanarchitecture.data.remote.CoinDto
import com.example.coincleanarchitecture.data.remote.toCoin
import com.example.coincleanarchitecture.domain.model.Coin
import com.example.coinscleanarchiture.domain.use_cases.GetCoinUseCase
import com.example.coinscleanarchiture.presentation.CoinListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class CoinListViewModelTest{
    private val getCoinUseCase: GetCoinUseCase = mock()

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
    @Test
    fun test_success() = runTest {
        val flows = flowOf(Resource.Success(getCoinsData().map { it.toCoin() }))
        whenever(getCoinUseCase.invoke()).thenReturn(flows)
        CoinListViewModel(getCoinUseCase).getCoins()
        assertEquals(
            getCoinsData().map { it.toCoin() }, CoinListViewModel(getCoinUseCase).state.value.coins
        )
    }

    @Test
    fun test_error() = runTest {
        val flow = flowOf(Resource.Error<List<Coin>>("error"))
        whenever(getCoinUseCase.invoke()).thenReturn(flow)
        CoinListViewModel(getCoinUseCase).getCoins()
        assertEquals(
            "error", CoinListViewModel(getCoinUseCase).state.value.error
        )
    }

    @Test
    fun test_loading() = runTest {
        val flow = flowOf(Resource.Loading<List<Coin>>())
        whenever(getCoinUseCase.invoke()).thenReturn(flow)
        CoinListViewModel(getCoinUseCase).getCoins()
        assertEquals(
            true, CoinListViewModel(getCoinUseCase).state.value.isLoading
        )
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