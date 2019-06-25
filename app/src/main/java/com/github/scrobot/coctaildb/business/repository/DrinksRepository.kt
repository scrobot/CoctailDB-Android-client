package com.github.scrobot.coctaildb.business.repository

import com.github.scrobot.coctaildb.business.model.Drink
import com.github.scrobot.coctaildb.business.model.DrinkCategory
import com.github.scrobot.coctaildb.business.model.DrinkPreview
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface DrinksRepository {

    fun saveDrinks(drinks: List<DrinkPreview>): Completable
    fun selectAllDrinks(): Maybe<List<DrinkPreview>>
    fun loadCategories(): Single<List<DrinkCategory>?>
    fun findDrinksByCategory(category: String): Single<List<DrinkPreview>?>
    fun requestDrinkDetails(id: String): Single<Drink>

}