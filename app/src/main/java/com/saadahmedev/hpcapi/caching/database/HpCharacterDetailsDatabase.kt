package com.saadahmedev.hpcapi.caching.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.saadahmedev.hpcapi.caching.converter.EntityTypeConverters
import com.saadahmedev.hpcapi.caching.dao.HpCharacterDetailsDao
import com.saadahmedev.hpcapi.caching.entity.HpCharacterDetailsEntity

@Database(entities = [HpCharacterDetailsEntity::class], version = 1, exportSchema = false)
@TypeConverters(EntityTypeConverters::class)
abstract class HpCharacterDetailsDatabase : RoomDatabase() {

    abstract fun hpCharacterDetailsDao(): HpCharacterDetailsDao

    companion object {
        @Volatile
        var instance: HpCharacterDetailsDatabase? = null

        fun getDatabaseInstance(context: Context): HpCharacterDetailsDatabase {
            if (instance != null) return instance as HpCharacterDetailsDatabase

            synchronized(this) {
                val roomDatabaseInstance = Room.databaseBuilder(
                    context,
                    HpCharacterDetailsDatabase::class.java,
                    "HpCharacterDetails"
                ).allowMainThreadQueries().build()

                instance = roomDatabaseInstance
                return instance as HpCharacterDetailsDatabase
            }
        }
    }
}