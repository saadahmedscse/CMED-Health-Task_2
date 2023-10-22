package com.saadahmedev.hpcapi.domain.model

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
)
