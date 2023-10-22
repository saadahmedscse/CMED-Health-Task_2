package com.saadahmedev.hpcapi.data.dto

import com.google.gson.annotations.SerializedName

data class Wand(
    @SerializedName("wood") var wood: String? = null,
    @SerializedName("core") var core: String? = null,
    @SerializedName("length") var length: Double? = null
)