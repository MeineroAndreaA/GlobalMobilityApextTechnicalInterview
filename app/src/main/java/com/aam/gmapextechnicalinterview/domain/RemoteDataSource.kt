package com.aam.gmapextechnicalinterview.domain

import com.aam.gmapextechnicalinterview.data.core.RickAndMorthyApiService
import com.aam.gmapextechnicalinterview.data.model.response.Character

class RemoteDataSource (private val api : RickAndMorthyApiService ) : RemoteRepository
{
    suspend fun getCharacters(page : Int?): RndMNetworkResult<Character> {
        return handleApi { api.getCharacters(page) }
    }
}