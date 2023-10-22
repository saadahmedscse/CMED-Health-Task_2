package com.saadahmedev.hpcapi.di

import android.content.Context
import com.saadahmedev.hpcapi.caching.dao.HpCharacterDao
import com.saadahmedev.hpcapi.caching.dao.HpCharacterDetailsDao
import com.saadahmedev.hpcapi.caching.database.HpCharacterDatabase
import com.saadahmedev.hpcapi.caching.database.HpCharacterDetailsDatabase
import com.saadahmedev.hpcapi.caching.repository.HpCharacterCacheRepository
import com.saadahmedev.hpcapi.caching.repository.HpCharacterDetailsCacheRepository
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

    @Provides
    @Singleton
    fun provideHpCharacterDetailsDao(@ApplicationContext context: Context): HpCharacterDetailsDao {
        return HpCharacterDetailsDatabase.getDatabaseInstance(context).hpCharacterDetailsDao()
    }

    @Provides
    @Singleton
    fun provideHpCharacterDetailsRepository(dao: HpCharacterDetailsDao): HpCharacterDetailsCacheRepository {
        return HpCharacterDetailsCacheRepository(dao)
    }
}