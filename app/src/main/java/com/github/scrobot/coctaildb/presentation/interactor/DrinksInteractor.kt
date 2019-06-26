package com.github.scrobot.coctaildb.presentation.interactor

import com.github.scrobot.coctaildb.business.model.DrinkCategory
import com.github.scrobot.coctaildb.business.model.DrinkPreview
import io.reactivex.Maybe
import io.reactivex.Single

interface DrinksInteractor {

    fun loadCategories(): Single<List<DrinkCategory>?>
    fun loadDrinks(): Maybe<List<DrinkPreview>>
}