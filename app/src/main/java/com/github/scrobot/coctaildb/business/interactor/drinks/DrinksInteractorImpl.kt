package com.github.scrobot.coctaildb.business.interactor.drinks

import com.github.scrobot.coctaildb.business.repository.DrinksRepository
import com.github.scrobot.coctaildb.presentation.interactor.DrinksInteractor

class DrinksInteractorImpl(
    private val drinksRepository: DrinksRepository
): DrinksInteractor {

    override fun loadCategories() = drinksRepository.loadCategories()

    override fun loadDrinks() = drinksRepository.selectAllDrinks()

}