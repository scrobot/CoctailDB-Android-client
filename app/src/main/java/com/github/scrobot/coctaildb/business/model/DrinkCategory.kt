package com.github.scrobot.coctaildb.business.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class DrinkCategory(
    @PrimaryKey
    @SerializedName("strCategory")
    @Expose
    val categoryId: String,
    var isChecked: Boolean = true
)