package com.saadahmedev.hpcapi.caching.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saadahmedev.hpcapi.domain.model.HpCharacter

@Entity("HpCharacter")
data class HpCharacterEntity(
    @PrimaryKey
    val id: String = "",
    val picture: String? = null,
    val name: String? = null,
    val actorName: String? = null,
    val houseName: String? = null
) {
    fun toHpCharacter(): HpCharacter {
        return HpCharacter(
            id, picture, name, actorName, houseName
        )
    }
}
