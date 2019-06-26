package com.github.scrobot.coctaildb.di.modules.common

import com.github.scrobot.coctaildb.Constants.BACKEND
import com.github.scrobot.coctaildb.data.api.ApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Qualifier

@Module
class NetworkModule {

    @Provides
    @Named(BACKEND.QUALIFIER)
    fun provideServerURL() = BACKEND.URL

    @Provides
    fun provideApiClient(@Named(BACKEND.QUALIFIER) url: String) = ApiClient(url)

    @Provides
    fun provideApi(apiClient: ApiClient) = apiClient.getApiService()

}