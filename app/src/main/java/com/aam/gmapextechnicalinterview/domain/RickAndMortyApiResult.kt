package com.aam.gmapextechnicalinterview.domain


/**
 * Generic class for handling network operation results.
 * @param T as the generic type of results, which can encompass a Response object of type [Character] or [Result].
 * @param code Returns a fixed status.
 * @param data Returns an object from the API response.
 * @param errorMsg Returns an error body.
 * @param e Returns an HTTP error.
 */
sealed class RndMNetworkResult<out T : Any> {
    data class Success<out T : Any>(val code: RickAndMortyStatus, val data: T) : RndMNetworkResult<T>()
    data class Error(val code: RickAndMortyStatus, val errorMsg: String?) : RndMNetworkResult<Nothing>()
    data class Exception(val code: RickAndMortyStatus, val e: Throwable) : RndMNetworkResult<Nothing>()
}