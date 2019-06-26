package com.github.scrobot.coctaildb.presentation.interactor

import com.github.scrobot.coctaildb.business.model.DrinkCategory
import com.github.scrobot.coctaildb.business.model.DrinkPreview
import com.github.scrobot.coctaildb.business.repository.DrinksRepository
import com.github.scrobot.coctaildb.business.repository.FilterRepository
import io.reactivex.Flowable
import io.reactivex.Single

interface LauncherInteractor {

    fun loadCategories(): Single<List<DrinkCategory>?>

    fun loadDrinks(): Flowable<List<DrinkPreview>?>

}