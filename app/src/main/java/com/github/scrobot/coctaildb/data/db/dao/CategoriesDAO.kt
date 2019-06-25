package com.github.scrobot.coctaildb.data.db.dao

import androidx.room.*
import com.github.scrobot.coctaildb.business.model.DrinkCategory
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
interface CategoriesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(categories: List<DrinkCategory>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCategories(categories: List<DrinkCategory>)

    @Query("SELECT * FROM drinkcategory")
    fun selectCategories(): Flowable<List<DrinkCategory>>

}