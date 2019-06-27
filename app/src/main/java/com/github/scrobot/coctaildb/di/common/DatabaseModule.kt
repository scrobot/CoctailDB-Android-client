package com.github.scrobot.coctaildb.di.common

import android.content.Context
import dagger.Module
import androidx.room.Room
import com.github.scrobot.coctaildb.data.db.DrinksDatabase
import dagger.Provides


@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(context: Context) = Room.databaseBuilder(context, DrinksDatabase::class.java, "cocktail_db")
        .build()

    @Provides
    fun provideCategoriesDAO(db: DrinksDatabase) = db.categoriesDAO

    @Provides
    fun provideDrinksDAO(db: DrinksDatabase) = db.drinksDAO

}