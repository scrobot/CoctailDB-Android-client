package com.github.scrobot.coctaildb.business.interactor.drinks

import com.github.scrobot.coctaildb.business.repository.DrinksRepository
import com.github.scrobot.coctaildb.presentation.interactor.DrinksInteractor
import io.reactivex.Flowable
import javax.inject.Inject

class DrinksInteractorImpl @Inject constructor(
    private val drinksRepository: DrinksRepository
): DrinksInteractor {

    override fun haveAnyActiveFilter() = drinksRepository.selectUncheckedCategories()
        .map { it.any { !it.isChecked } }

    override fun loadCategories() = drinksRepository.loadCategories()

    override fun loadDrinks() = drinksRepository.selectAllDrinks()

}