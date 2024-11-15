package com.example.coincleanarchitecture.domain.use_cases


import com.example.coincleanarchitecture.common.Resource
import com.example.coincleanarchitecture.data.remote.dto.toCoin
import com.example.coincleanarchitecture.domain.model.Coin
import com.example.coincleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e:Exception){
            emit(Resource.Error(e.localizedMessage?:"An unexpected error occurred"))
        }
    }.flowOn(Dispatchers.IO)
}