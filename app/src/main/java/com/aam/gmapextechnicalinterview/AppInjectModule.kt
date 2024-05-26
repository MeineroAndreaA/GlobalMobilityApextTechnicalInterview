package com.aam.gmapextechnicalinterview

import com.aam.gmapextechnicalinterview.data.core.RetrofitModule
import com.aam.gmapextechnicalinterview.data.core.RickAndMorthyApiService
import com.aam.gmapextechnicalinterview.domain.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger module providing dependency instances for the application.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppInjectModule {

    /**
     * Provides a singleton instance of [RickAndMorthyApiService] using the [RetrofitModule.api] object.
     *
     * @return Instance of [RickAndMorthyApiService].
     */
    @Provides
    @Singleton
    fun provideApiService(): RickAndMorthyApiService {
        return RetrofitModule.api
    }

    /**
     * Provides a singleton instance of [RemoteDataSource] which requires an instance of [RickAndMorthyApiService].
     *
     * @param apiService Instance of [RickAndMorthyApiService] provided by Dagger.
     * @return Instance of [RemoteDataSource].
     */
    @Provides
    @Singleton
    fun provideInstanceOfRemoteDataSource(apiService: RickAndMorthyApiService): RemoteDataSource {
        return RemoteDataSource(apiService)
    }

}