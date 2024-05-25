package com.aam.gmapextechnicalinterview.domain

import retrofit2.HttpException
import retrofit2.Response

interface RemoteRepository {

    suspend fun <T : Any> handleApi(
        execute: suspend () -> Response<T>
    ): RndMNetworkResult<T> {
        return try {
            val response = execute()
            if (response.isSuccessful) {
                RndMNetworkResult.Success(RickAndMortyStatus.SUCCESS, response.body()!!)
            } else {
                RndMNetworkResult.Error(RickAndMortyStatus.ERROR, response.errorBody()?.string())
            }
        } catch (e: HttpException) {
            RndMNetworkResult.Error(RickAndMortyStatus.ERROR, e.message())
        } catch (e: Throwable) {
            e.printStackTrace(System.out)
            RndMNetworkResult.Exception(RickAndMortyStatus.THROWABLE, e)
        }
    }
}