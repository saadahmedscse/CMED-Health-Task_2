package com.saadahmedev.hpcapi.caching.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.saadahmedev.hpcapi.caching.dao.HpCharacterDao
import com.saadahmedev.hpcapi.caching.entity.HpCharacterEntity

@Database(entities = [HpCharacterEntity::class], version = 1, exportSchema = false)
abstract class HpCharacterDatabase : RoomDatabase() {

    abstract fun hpCharacterDao(): HpCharacterDao

    companion object {
        @Volatile
        var instance: HpCharacterDatabase? = null

        fun getDatabaseInstance(context: Context): HpCharacterDatabase {
            if (instance != null) return instance as HpCharacterDatabase

            synchronized(this) {
                val roomDatabaseInstance = Room.databaseBuilder(
                    context,
                    HpCharacterDatabase::class.java,
                    "HpCharacter"
                ).allowMainThreadQueries().build()

                instance = roomDatabaseInstance
                return instance as HpCharacterDatabase
            }
        }
    }
}