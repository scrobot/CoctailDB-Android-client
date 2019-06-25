package com.github.scrobot.coctaildb.business.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class DrinkPreview(
    @PrimaryKey
    @SerializedName("idDrink")
    @Expose
    var id: String,
    @SerializedName("strDrink")
    @Expose
    val name: String,
    @SerializedName("strDrinkThumb")
    @Expose
    val thumb: String? = null
)