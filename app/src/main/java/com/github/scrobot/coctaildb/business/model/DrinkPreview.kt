package com.github.scrobot.coctaildb.business.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class DrinkPreview(
    @PrimaryKey
    var id: String,
    val name: String,
    val thumb: String? = null,
    val category: String
)