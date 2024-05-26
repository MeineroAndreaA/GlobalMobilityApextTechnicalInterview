package com.aam.gmapextechnicalinterview.domain

import com.aam.gmapextechnicalinterview.data.core.RickAndMorthyApiService
import com.aam.gmapextechnicalinterview.data.model.response.Character
import com.aam.gmapextechnicalinterview.data.model.response.Results
import javax.inject.Inject

/**
 * Class for fetching external data.
 * @property api Returns the Retrofit instance that contains the configuration to access the Rick and Morty API.
 * It is injected into the view models.
 * @see com.aam.gmapextechnicalinterview.presentation.view_model.MainViewModel
 */
class RemoteDataSource @Inject constructor(private val api: RickAndMorthyApiService) :
    RemoteRepository {

    /**
     * Retrieves a list of characters, which can come with filters/query parameters.
     * A single entry point is used since the endpoint for character retrieval is the same; only its parameters vary.
     * @param page Indicates the page of characters, if null, it will show the first or last page.
     * If it has a value, it will be used for pagination of the list.
     * @param name Together with the page, returns a list of characters that match the characters or the full name of the character.
     * @param status Together with the page, returns a list of characters filtered by status.
     * @param specie Together with the page, returns a list of characters filtered by species.
     * @return Taken from the interface.
     * @see com.aam.gmapextechnicalinterview.domain.RemoteRepository
     * The handleApi method that handles API responses in a generic way and its variants (success, error, HTTP error).
     */
    suspend fun getCharacters(
        page: Int?,
        name: String?,
        status: String?,
        specie: String?
    ): RndMNetworkResult<Character> {
        return handleApi { api.getCharacters(page, name, status, specie) }
    }

    /**
     * Retrieves a single character based on the ID.
     * @param id ID obtained when selecting a single character from the character list.
     */
    suspend fun getSingleCharacter(id: Int): RndMNetworkResult<Results> {
        return handleApi { api.getSingleCharacter(id) }
    }
}