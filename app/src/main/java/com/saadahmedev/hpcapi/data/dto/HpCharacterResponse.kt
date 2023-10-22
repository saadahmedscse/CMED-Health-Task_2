package com.saadahmedev.hpcapi.data.dto

import com.google.gson.annotations.SerializedName
import com.saadahmedev.hpcapi.domain.model.HpCharacter
import com.saadahmedev.hpcapi.domain.model.HpCharacterDetails

data class HpCharacterResponse(
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("alternate_names") var alternateNames: ArrayList<String> = arrayListOf(),
    @SerializedName("species") var species: String? = null,
    @SerializedName("gender") var gender: String? = null,
    @SerializedName("house") var house: String? = null,
    @SerializedName("dateOfBirth") var dateOfBirth: String? = null,
    @SerializedName("yearOfBirth") var yearOfBirth: Int? = null,
    @SerializedName("wizard") var wizard: Boolean? = null,
    @SerializedName("ancestry") var ancestry: String? = null,
    @SerializedName("eyeColour") var eyeColour: String? = null,
    @SerializedName("hairColour") var hairColour: String? = null,
    @SerializedName("wand") var wand: Wand? = Wand(),
    @SerializedName("patronus") var patronus: String? = null,
    @SerializedName("hogwartsStudent") var hogwartsStudent: Boolean? = null,
    @SerializedName("hogwartsStaff") var hogwartsStaff: Boolean? = null,
    @SerializedName("actor") var actor: String? = null,
    @SerializedName("alternate_actors") var alternateActors: ArrayList<String> = arrayListOf(),
    @SerializedName("alive") var alive: Boolean? = null,
    @SerializedName("image") var image: String? = null
) {
    fun toHpCharacter(): HpCharacter {
        return HpCharacter(
            id = this.id,
            picture = this.image,
            name = this.name,
            actorName = this.actor,
            houseName = this.house
        )
    }

    fun toHpCharacterDetails(): HpCharacterDetails {
        return HpCharacterDetails(
            picture = this.image,
            name = this.name,
            actorName = this.actor,
            houseName = this.house,
            alternateNames = this.alternateNames,
            gender = this.gender,
            dateOfBirth = this.dateOfBirth,
            wizard = this.wizard,
            eyeColour = this.eyeColour,
            hairColour = this.hairColour,
            hogwartsStudent = this.hogwartsStudent,
            hogwartsStaff = this.hogwartsStaff,
            wand = this.wand,
            alive = this.alive
        )
    }
}