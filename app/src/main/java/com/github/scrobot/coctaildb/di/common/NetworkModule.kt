package com.github.scrobot.coctaildb.di.common

import com.github.scrobot.coctaildb.Constants.BACKEND
import com.github.scrobot.coctaildb.data.api.ApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.xml.datatype.DatatypeConstants.SECONDS
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton



@Module
class NetworkModule {

    @Provides
    @Named(BACKEND.QUALIFIER)
    fun provideServerURL() = BACKEND.URL

    @Provides
    @Singleton
    fun provideClient() = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    @Provides
    fun provideApiClient(@Named(BACKEND.QUALIFIER) url: String, okHttpClient: OkHttpClient) = ApiClient(url, okHttpClient)

    @Provides
    fun provideApi(apiClient: ApiClient) = apiClient.getApiService()

}