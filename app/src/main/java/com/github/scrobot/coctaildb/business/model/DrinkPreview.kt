package com.github.scrobot.coctaildb.business.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DrinkPreview(
    @SerializedName("strDrink")
    @Expose
    val name: String,
    @SerializedName("strDrinkThumb")
    @Expose
    val thumb: String? = null,
    @SerializedName("idDrink")
    @Expose
    var id: String
)