package com.aam.gmapextechnicalinterview.domain

sealed class RndMNetworkResult<out T : Any> {
    data class Success<out T : Any>(val code: RickAndMortyStatus, val data: T) : RndMNetworkResult<T>()
    data class Error(val code: RickAndMortyStatus, val errorMsg: String?) : RndMNetworkResult<Nothing>()
    data class Exception(val code: RickAndMortyStatus, val e: Throwable) : RndMNetworkResult<Nothing>()
}