package com.github.scrobot.coctaildb.business.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DrinkCategory(
    @SerializedName("strCategory")
    @Expose
    val categoryId: String
)