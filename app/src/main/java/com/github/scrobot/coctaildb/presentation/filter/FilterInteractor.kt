package com.github.scrobot.coctaildb.presentation.filter

import com.github.scrobot.coctaildb.business.model.DrinkCategory
import io.reactivex.Completable
import io.reactivex.Flowable

interface FilterInteractor {

    fun selectCategories(): Flowable<List<DrinkCategory>>
    fun updateCategories(list: List<DrinkCategory>): Completable

}