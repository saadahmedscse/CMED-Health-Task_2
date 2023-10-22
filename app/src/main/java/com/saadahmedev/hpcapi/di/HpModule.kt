package com.saadahmedev.hpcapi.di

import com.saadahmedev.hpcapi.data.repository.HpRepositoryImpl
import com.saadahmedev.hpcapi.data.source.HpApi
import com.saadahmedev.hpcapi.domain.repository.HpRepository
import com.saadahmedev.hpcapi.util.Constants.Api.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HpModule {

    @Provides
    @Singleton
    fun provideHpApi(): HpApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HpApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHpRepository(hpApi: HpApi): HpRepository {
        return HpRepositoryImpl(hpApi)
    }
}