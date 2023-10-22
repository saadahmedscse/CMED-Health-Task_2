package com.saadahmedev.hpcapi.caching.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saadahmedev.hpcapi.caching.entity.HpCharacterDetailsEntity

@Dao
interface HpCharacterDetailsDao {

    @Query("SELECT * FROM HpCharacterDetails WHERE id=:id")
    fun getCharacterDetails(id: String): HpCharacterDetailsEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacterDetails(characterDetails: HpCharacterDetailsEntity)
}