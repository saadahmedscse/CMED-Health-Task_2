package com.saadahmedev.hpcapi.caching.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.saadahmedev.hpcapi.data.dto.Wand

class EntityTypeConverters {
    @TypeConverter
    fun fromArrayList(value: ArrayList<String>?): String? {
        return value?.joinToString(",")
    }

    @TypeConverter
    fun toArrayList(value: String?): ArrayList<String>? {
        return value?.split(",")?.toCollection(ArrayList())
    }

    @TypeConverter
    fun fromWand(wand: Wand?): String? {
        return Gson().toJson(wand)
    }

    @TypeConverter
    fun toWand(json: String?): Wand? {
        return Gson().fromJson(json, Wand::class.java)
    }
}