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

    private val api: RickAndMorthyApiService by lazy {
        retrofitFactory.create(RickAndMorthyApiService::class.java)
    }
}