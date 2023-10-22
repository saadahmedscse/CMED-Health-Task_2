package com.saadahmedev.hpcapi.caching.repository

import com.saadahmedev.hpcapi.caching.dao.HpCharacterDao
import com.saadahmedev.hpcapi.caching.entity.HpCharacterEntity

class HpCharacterCacheRepository(private val dao: HpCharacterDao) {

    fun getCharacters(): List<HpCharacterEntity> = dao.getCharacters()

    fun insertCharacters(characters: List<HpCharacterEntity>) {
        dao.insertCharacters(characters)
    }
}