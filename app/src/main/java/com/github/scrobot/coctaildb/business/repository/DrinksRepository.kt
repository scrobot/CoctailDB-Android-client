package com.github.scrobot.coctaildb.business.repository

import com.github.scrobot.coctaildb.business.model.Drink
import com.github.scrobot.coctaildb.business.model.DrinkCategory
import com.github.scrobot.coctaildb.business.model.DrinkPreview
import com.github.scrobot.coctaildb.business.model.DrinkPreviewDTO
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

interface DrinksRepository {

    fun selectUncheckedCategories(): Flowable<List<DrinkCategory>>
    fun saveDrinks(drinks: List<DrinkPreview>)
    fun selectAllDrinks(): Maybe<List<DrinkPreview>>
    fun loadCategories(): Single<List<DrinkCategory>?>
    fun findDrinksByCategory(category: String): Single<List<DrinkPreviewDTO>?>
    fun requestDrinkDetails(id: String): Single<Drink>

}