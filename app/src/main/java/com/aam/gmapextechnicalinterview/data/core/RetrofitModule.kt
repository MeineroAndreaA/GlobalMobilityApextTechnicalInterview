package com.aam.gmapextechnicalinterview.data.core

import com.aam.gmapextechnicalinterview.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitModule {

    private const val domainBaseUrl = BuildConfig.BASE_URL

    private val retrofitFactory by lazy {
        Retrofit.Builder()
            .baseUrl(domainBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * @return Initialized singleton instance for external use, for consuming the Rick and Morty API.
     */
    val api: RickAndMorthyApiService by lazy {
        retrofitFactory.create(RickAndMorthyApiService::class.java)
    }
}