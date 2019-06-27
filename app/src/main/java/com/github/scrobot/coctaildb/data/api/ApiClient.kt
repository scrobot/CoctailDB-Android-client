package com.github.scrobot.coctaildb.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient(
    private val backendUrl: String,
    private val okHttpClient: OkHttpClient) {

    fun getApiService() = Retrofit.Builder()
        .baseUrl(backendUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(API::class.java)

}