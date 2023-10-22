package com.saadahmedev.hpcapi.domain.repository

import com.saadahmedev.hpcapi.data.dto.HpCharacterResponse

interface HpRepository {

    suspend fun getCharacters(): List<HpCharacterResponse>

    suspend fun getCharacter(id: String): List<HpCharacterResponse>
}