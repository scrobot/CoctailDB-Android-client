package com.github.scrobot.coctaildb.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.scrobot.coctaildb.business.model.DrinkPreview
import io.reactivex.Maybe

@Dao
interface DrinksDAO {

    @Insert
    fun insertDrinks(drinks: List<DrinkPreview>)

    @Query("SELECT * FROM drinkpreview")
    fun selectDrinks(): Maybe<List<DrinkPreview>>

}