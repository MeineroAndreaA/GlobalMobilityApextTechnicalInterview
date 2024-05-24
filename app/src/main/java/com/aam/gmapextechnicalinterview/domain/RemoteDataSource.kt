package com.aam.gmapextechnicalinterview.domain

import com.aam.gmapextechnicalinterview.data.core.RickAndMorthyApiService
import com.aam.gmapextechnicalinterview.data.model.response.Character
import com.aam.gmapextechnicalinterview.data.model.response.Results

class RemoteDataSource(private val api: RickAndMorthyApiService) : RemoteRepository {
    suspend fun getCharacters(page: Int?): RndMNetworkResult<Character> {
        return handleApi { api.getCharacters(page) }
    }

    suspend fun getSingleCharacter(id: Int): RndMNetworkResult<Results> {
        return handleApi { api.getSingleCharacter(id) }
    }
}