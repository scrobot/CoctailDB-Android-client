package com.github.scrobot.coctaildb.business.repository

import com.github.scrobot.coctaildb.business.model.DrinkCategory
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

interface FilterRepository {

    fun selectCategories(): Flowable<List<DrinkCategory>>
    fun updateCategories(list: List<DrinkCategory>): Completable

}