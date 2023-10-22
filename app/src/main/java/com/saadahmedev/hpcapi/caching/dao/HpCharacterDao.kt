package com.saadahmedev.hpcapi.caching.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saadahmedev.hpcapi.caching.entity.HpCharacterEntity

@Dao
interface HpCharacterDao {

    @Query("SELECT * FROM HpCharacter")
    fun getCharacters(): List<HpCharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacters(characters: List<HpCharacterEntity>)
}