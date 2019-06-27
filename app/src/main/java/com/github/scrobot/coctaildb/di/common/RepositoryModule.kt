package com.github.scrobot.coctaildb.di.common

import com.github.scrobot.coctaildb.business.repository.DrinksRepository
import com.github.scrobot.coctaildb.business.repository.FilterRepository
import com.github.scrobot.coctaildb.data.api.API
import com.github.scrobot.coctaildb.data.db.dao.CategoriesDAO
import com.github.scrobot.coctaildb.data.db.dao.DrinksDAO
import com.github.scrobot.coctaildb.data.repository.drinks.DrinksRepositoryImpl
import com.github.scrobot.coctaildb.data.repository.filter.FilterRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideDrinksRepository(
        api: API,
        categoriesDAO: CategoriesDAO,
        drinksDAO: DrinksDAO
    ): DrinksRepository = DrinksRepositoryImpl(api, categoriesDAO, drinksDAO)

    @Provides
    fun provideFilterRepository(categoriesDAO: CategoriesDAO): FilterRepository = FilterRepositoryImpl(categoriesDAO)
}