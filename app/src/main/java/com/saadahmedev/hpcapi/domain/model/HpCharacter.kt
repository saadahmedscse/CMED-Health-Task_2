package com.saadahmedev.hpcapi.domain.model

import com.saadahmedev.hpcapi.caching.entity.HpCharacterEntity

data class HpCharacter(
    val id: String? = null,
    val picture: String? = null,
    val name: String? = null,
    val actorName: String? = null,
    val houseName: String? = null
) {
    fun toHpCharacterEntity(): HpCharacterEntity {
        return HpCharacterEntity(
            id!!, picture, name, actorName, houseName
        )
    }
}
