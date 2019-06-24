package com.github.scrobot.coctaildb.data.api

import com.github.scrobot.coctaildb.business.model.DrinkPreview
import com.github.scrobot.coctaildb.business.model.DrinkCategory
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET("lookup.php?i=11007")
    fun getDrinkDetails(@Query("i") id: String)

    @GET("filter.php?")
    fun getDrinksByCategory(@Query("c") category: String): Single<Map<String, List<DrinkPreview>>>

    @GET("list.php?c=list")
    fun getCategories(): Single<Map<String, List<DrinkCategory>>>

}