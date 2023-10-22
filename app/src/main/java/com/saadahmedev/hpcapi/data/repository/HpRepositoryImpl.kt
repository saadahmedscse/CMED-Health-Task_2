package com.saadahmedev.hpcapi.data.repository

import com.saadahmedev.hpcapi.data.dto.HpCharacterResponse
import com.saadahmedev.hpcapi.data.source.HpApi
import com.saadahmedev.hpcapi.domain.repository.HpRepository
import javax.inject.Inject

class HpRepositoryImpl @Inject constructor(private val hpApi: HpApi) : HpRepository {

    override suspend fun getCharacters(): List<HpCharacterResponse> = hpApi.getCharacters()

    override suspend fun getCharacter(id: String): List<HpCharacterResponse> = hpApi.getCharacter(id)
}