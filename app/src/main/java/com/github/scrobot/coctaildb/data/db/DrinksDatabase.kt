package com.github.scrobot.coctaildb.data.db

import androidx.room.RoomDatabase
import androidx.room.Database
import com.github.scrobot.coctaildb.business.model.DrinkCategory
import com.github.scrobot.coctaildb.business.model.DrinkPreview
import com.github.scrobot.coctaildb.data.db.dao.CategoriesDAO
import com.github.scrobot.coctaildb.data.db.dao.DrinksDAO


@Database(entities = [DrinkCategory::class, DrinkPreview::class], version = 1)
abstract class DrinksDatabase : RoomDatabase() {

    abstract val categoriesDAO: CategoriesDAO
    abstract val drinksDAO: DrinksDAO

}