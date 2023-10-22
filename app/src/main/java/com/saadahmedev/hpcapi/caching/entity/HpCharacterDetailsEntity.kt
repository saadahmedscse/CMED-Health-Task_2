package com.saadahmedev.hpcapi.caching.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saadahmedev.hpcapi.data.dto.Wand
import com.saadahmedev.hpcapi.domain.model.HpCharacterDetails

@Entity("HpCharacterDetails")
data class HpCharacterDetailsEntity(
    @PrimaryKey
    val id: String = "",
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
    fun toHpCharacterDetails(): HpCharacterDetails {
        return HpCharacterDetails(
            picture, name, actorName, houseName, alternateNames, gender, dateOfBirth, wizard, eyeColour, hairColour, hogwartsStudent, hogwartsStaff, wand, alive
        )
    }
}
