package com.aam.gmapextechnicalinterview.data.core

import com.aam.gmapextechnicalinterview.data.model.response.Character
import com.aam.gmapextechnicalinterview.data.model.response.Results
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMorthyApiService {

    @GET("character/")
    suspend fun getCharacters(
        @Query("page") page: Int?,
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("species") species: String?
    ): Response<Character>

    @GET("character/")
    suspend fun getCharactersByName(
        @Query("name") name: String?
    ): Response<Character>

    @GET("character/")
    suspend fun getCharactersByStatus(
        @Query("status") status: String?
    ): Response<Character>

    @GET("character/")
    suspend fun getCharactersBySpecie(
        @Query("species") species: String?
    ): Response<Character>

    @GET("character/{id}")
    suspend fun getSingleCharacter(@Path("id") id: Int): Response<Results>
}