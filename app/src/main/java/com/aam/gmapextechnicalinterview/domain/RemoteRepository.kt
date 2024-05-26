package com.aam.gmapextechnicalinterview.domain

import retrofit2.HttpException
import retrofit2.Response


/**
 * Interface for making a generic API call and handling its possible responses.
 */
interface RemoteRepository {

    /**
     * @param execute Suspended function that executes the API call.
     * @return [RndMNetworkResult] that handles the 3 types of responses that the API can give.
     * @see com.aam.gmapextechnicalinterview.domain.RndMNetworkResult
     */
    suspend fun <T : Any> handleApi(
        execute: suspend () -> Response<T>
    ): RndMNetworkResult<T> {
        try {
            val response = execute()
            return if (response.isSuccessful) {
                RndMNetworkResult.Success(RickAndMortyStatus.SUCCESS, response.body()!!)
            } else {
                RndMNetworkResult.Error(RickAndMortyStatus.ERROR, response.errorBody()?.string())
            }
        } catch (e: HttpException) {
            return  RndMNetworkResult.Error(RickAndMortyStatus.ERROR, e.message())
        } catch (e: Throwable) {
            return  RndMNetworkResult.Exception(RickAndMortyStatus.THROWABLE, e)
        }
    }
}