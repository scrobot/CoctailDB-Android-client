package com.github.scrobot.coctaildb.business.interactor.launcher

import com.github.scrobot.coctaildb.business.repository.DrinksRepository
import com.github.scrobot.coctaildb.business.repository.FilterRepository
import com.github.scrobot.coctaildb.presentation.interactor.LauncherInteractor

class LauncherInteractorImpl(
    private val drinksRepository: DrinksRepository,
    private val categoriesRepository: FilterRepository
): LauncherInteractor {

    override fun loadCategories() = drinksRepository.loadCategories()

    override fun loadDrinks() = categoriesRepository.selectCategories()
        .flatMapIterable { it }
        .flatMap { drinksRepository.findDrinksByCategory(it.categoryId).toFlowable() }
        .doOnNext { drinksRepository.saveDrinks(it ?: emptyList()) }

}