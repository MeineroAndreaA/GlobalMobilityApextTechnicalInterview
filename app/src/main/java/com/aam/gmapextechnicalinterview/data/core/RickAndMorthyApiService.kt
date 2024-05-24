package com.aam.gmapextechnicalinterview.data.core

import com.aam.gmapextechnicalinterview.data.model.response.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMorthyApiService {

    @GET("characters/")
    suspend fun getCharacters(@Query("page") page : Int?): Response<Character>
}