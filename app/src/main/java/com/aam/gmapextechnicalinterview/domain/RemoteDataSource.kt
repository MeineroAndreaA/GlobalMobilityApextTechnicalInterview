package com.aam.gmapextechnicalinterview.domain

import com.aam.gmapextechnicalinterview.data.core.RickAndMorthyApiService
import com.aam.gmapextechnicalinterview.data.model.response.Character
import com.aam.gmapextechnicalinterview.data.model.response.Results
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: RickAndMorthyApiService) :
    RemoteRepository {
    suspend fun getCharacters(
        page: Int?,
        name: String?,
        status: String?,
        specie: String?
    ): RndMNetworkResult<Character> {
        return handleApi { api.getCharacters(page, name, status, specie) }
    }

    suspend fun getSingleCharacter(id: Int): RndMNetworkResult<Results> {
        return handleApi { api.getSingleCharacter(id) }
    }
}