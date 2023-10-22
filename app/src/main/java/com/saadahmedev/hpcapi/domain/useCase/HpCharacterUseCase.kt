package com.saadahmedev.hpcapi.domain.useCase

import android.content.Context
import com.saadahmedev.hpcapi.caching.entity.HpCharacterEntity
import com.saadahmedev.hpcapi.caching.repository.HpCharacterCacheRepository
import com.saadahmedev.hpcapi.caching.repository.HpCharacterDetailsCacheRepository
import com.saadahmedev.hpcapi.domain.model.HpCharacter
import com.saadahmedev.hpcapi.domain.model.HpCharacterDetails
import com.saadahmedev.hpcapi.domain.repository.HpRepository
import com.saadahmedev.hpcapi.util.ResponseState
import com.saadahmedev.hpcapi.util.isInternetAvailable
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HpCharacterUseCase @Inject constructor(
    private val hpRepository: HpRepository,
    private val hpCharacterCacheRepository: HpCharacterCacheRepository,
    private val hpCharacterDetailsCacheRepository: HpCharacterDetailsCacheRepository,
    @ApplicationContext private val context: Context
) {

    fun getCharacters(): Flow<ResponseState<List<HpCharacter>>> = flow {
        try {
            emit(ResponseState.Loading())

            val newCachedCharacterList = arrayListOf<HpCharacterEntity>()
            if (isInternetAvailable(context)) {
                val hpCharacterList = hpRepository.getCharacters().map { it.toHpCharacter() }

                val cachedCharacterList = hpCharacterCacheRepository.getCharacters()
                val cachedCharacterIdSet = mutableSetOf<String>()
                for (character in cachedCharacterList) cachedCharacterIdSet.add(character.id)
                for (character in hpCharacterList) if (!cachedCharacterIdSet.contains(character.id)) newCachedCharacterList.add(character.toHpCharacterEntity())
            }

            hpCharacterCacheRepository.insertCharacters(newCachedCharacterList)
            val finalCachedCharacterList = hpCharacterCacheRepository.getCharacters().map { it.toHpCharacter() }

            if (finalCachedCharacterList.isNotEmpty()) emit(ResponseState.Success(finalCachedCharacterList))
            else emit(ResponseState.Error("No Internet Connection"))
        } catch (e: Exception) {
            emit(ResponseState.Error(e.localizedMessage ?: "Unexpected Error Occurred"))
        }
    }

    fun getCharacter(id: String): Flow<ResponseState<HpCharacterDetails>> = flow {
        try {
            emit(ResponseState.Loading())

            val cachedCharacterDetails = hpCharacterDetailsCacheRepository.getCharacterDetails(id)
            if (cachedCharacterDetails == null) {
                if (!isInternetAvailable(context)) {
                    emit(ResponseState.Error("No Internet Connection"))
                } else {
                    val hpCharacterDetails = hpRepository.getCharacter(id)[0].toHpCharacterDetails()
                    emit(ResponseState.Success(hpCharacterDetails))
                    hpCharacterDetailsCacheRepository.insertCharacterDetails(hpCharacterDetails.toHpCharacterDetailsEntity(id))
                }
            }
            else {
                emit(ResponseState.Success(cachedCharacterDetails.toHpCharacterDetails()))
            }
        } catch (e: Exception) {
            emit(ResponseState.Error(e.localizedMessage ?: "Unexpected Error Occurred"))
        }
    }
}