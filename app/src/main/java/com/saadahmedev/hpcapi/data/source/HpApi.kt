package com.saadahmedev.hpcapi.data.source

import com.saadahmedev.hpcapi.data.dto.HpCharacterResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface HpApi {

    @Headers("Accept: application/json")
    @GET("characters")
    suspend fun getCharacters(): List<HpCharacterResponse>

    @Headers("Accept: application/json")
    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: String): List<HpCharacterResponse>
}