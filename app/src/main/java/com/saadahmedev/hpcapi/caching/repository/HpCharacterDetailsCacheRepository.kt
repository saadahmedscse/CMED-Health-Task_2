package com.saadahmedev.hpcapi.caching.repository

import com.saadahmedev.hpcapi.caching.dao.HpCharacterDetailsDao
import com.saadahmedev.hpcapi.caching.entity.HpCharacterDetailsEntity

class HpCharacterDetailsCacheRepository(private val dao: HpCharacterDetailsDao) {

    fun insertCharacterDetails(characterDetails: HpCharacterDetailsEntity) {
        dao.insertCharacterDetails(characterDetails)
    }

    fun getCharacterDetails(id: String): HpCharacterDetailsEntity? = dao.getCharacterDetails(id)
}