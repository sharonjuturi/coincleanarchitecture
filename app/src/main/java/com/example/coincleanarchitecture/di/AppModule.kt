package com.example.coinscleanarchiture.di

import com.example.coincleanarchitecture.common.Constants
import com.example.coinscleanarchiture.data.remote.CoinApiService
import com.example.coinscleanarchiture.data.repository.CoinRepositoryImpl
import com.example.coinscleanarchiture.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(provideLoggingInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideCoinApi(okHttpClient: OkHttpClient): CoinApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CoinApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApiService): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}
