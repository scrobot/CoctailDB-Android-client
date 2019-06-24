package com.github.scrobot.coctaildb.data.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient(private val backendUrl: String) {

    fun getApiService() = Retrofit.Builder()
        .baseUrl(backendUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(API::class.java)

}