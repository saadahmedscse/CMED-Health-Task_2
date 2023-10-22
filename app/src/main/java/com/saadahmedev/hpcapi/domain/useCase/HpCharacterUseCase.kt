package com.saadahmedev.hpcapi.domain.useCase

import com.saadahmedev.hpcapi.domain.model.HpCharacter
import com.saadahmedev.hpcapi.domain.model.HpCharacterDetails
import com.saadahmedev.hpcapi.domain.repository.HpRepository
import com.saadahmedev.hpcapi.util.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HpCharacterUseCase @Inject constructor(private val hpRepository: HpRepository) {

    fun getCharacters(): Flow<ResponseState<List<HpCharacter>>> = flow {
        try {
            emit(ResponseState.Loading())

            val hpCharacterList = hpRepository.getCharacters().map {
                it.toHpCharacter()
            }
            emit(ResponseState.Success(hpCharacterList))
        } catch (e: Exception) {
            emit(ResponseState.Error(e.localizedMessage ?: "Unexpected Error Occurred"))
        }
    }

    fun getCharacter(id: String): Flow<ResponseState<HpCharacterDetails>> = flow {
        try {
            emit(ResponseState.Loading())

            val hpCharacterDetails = hpRepository.getCharacter(id)[0].toHpCharacterDetails()
            emit(ResponseState.Success(hpCharacterDetails))
        } catch (e: Exception) {
            emit(ResponseState.Error(e.localizedMessage ?: "Unexpected Error Occurred"))
        }
    }
}