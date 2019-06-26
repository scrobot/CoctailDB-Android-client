package com.github.scrobot.coctaildb.business.interactor.filter

import com.github.scrobot.coctaildb.business.model.DrinkCategory
import com.github.scrobot.coctaildb.business.repository.FilterRepository
import com.github.scrobot.coctaildb.presentation.interactor.FilterInteractor
import io.reactivex.Completable
import io.reactivex.Flowable

class FilterInteractorImpl(
    private val repository: FilterRepository
): FilterInteractor {

    override fun selectCategories(): Flowable<List<DrinkCategory>> = repository.selectCategories()

    override fun updateCategories(list: List<DrinkCategory>): Completable = updateCategories(list)

}