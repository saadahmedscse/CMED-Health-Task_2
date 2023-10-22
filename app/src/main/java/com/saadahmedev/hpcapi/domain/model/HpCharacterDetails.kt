package com.saadahmedev.hpcapi.domain.model

import com.saadahmedev.hpcapi.caching.entity.HpCharacterDetailsEntity
import com.saadahmedev.hpcapi.data.dto.Wand

data class HpCharacterDetails(
    val picture: String? = null,
    val name: String? = null,
    val actorName: String? = null,
    val houseName: String? = null,
    val alternateNames: ArrayList<String> = arrayListOf(),
    val gender: String? = null,
    val dateOfBirth: String? = null,
    val wizard: Boolean? = null,
    val eyeColour: String? = null,
    val hairColour: String? = null,
    val hogwartsStudent: Boolean? = null,
    val hogwartsStaff: Boolean? = null,
    val wand: Wand? = Wand(),
    val alive: Boolean? = null
) {
    fun toHpCharacterDetailsEntity(id: String): HpCharacterDetailsEntity {
        return HpCharacterDetailsEntity(
            id, picture, name, actorName, houseName, alternateNames, gender, dateOfBirth, wizard, eyeColour, hairColour, hogwartsStudent, hogwartsStaff, wand, alive
        )
    }
}
