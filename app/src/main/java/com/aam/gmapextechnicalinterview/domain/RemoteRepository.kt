package com.aam.gmapextechnicalinterview.domain

import retrofit2.HttpException
import retrofit2.Response

interface RemoteRepository {

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