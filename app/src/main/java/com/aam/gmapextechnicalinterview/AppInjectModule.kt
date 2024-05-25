package com.aam.gmapextechnicalinterview

import com.aam.gmapextechnicalinterview.data.core.RetrofitModule
import com.aam.gmapextechnicalinterview.data.core.RickAndMorthyApiService
import com.aam.gmapextechnicalinterview.domain.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppInjectModule {

    @Provides
    @Singleton
    fun provideApiService(): RickAndMorthyApiService {
        return RetrofitModule.api
    }

    @Provides
    @Singleton
    fun provideInstanceOfRemoteDataSource(apiService: RickAndMorthyApiService): RemoteDataSource {
        return RemoteDataSource(apiService)
    }

}