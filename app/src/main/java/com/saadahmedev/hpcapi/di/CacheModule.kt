package com.saadahmedev.hpcapi.di

import android.content.Context
import com.saadahmedev.hpcapi.caching.dao.HpCharacterDao
import com.saadahmedev.hpcapi.caching.database.HpCharacterDatabase
import com.saadahmedev.hpcapi.caching.repository.HpCharacterCacheRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideHpCharacterDao(@ApplicationContext context: Context): HpCharacterDao {
        return HpCharacterDatabase.getDatabaseInstance(context).hpCharacterDao()
    }

    @Provides
    @Singleton
    fun provideHpCharacterRepository(dao: HpCharacterDao): HpCharacterCacheRepository {
        return HpCharacterCacheRepository(dao)
    }
}