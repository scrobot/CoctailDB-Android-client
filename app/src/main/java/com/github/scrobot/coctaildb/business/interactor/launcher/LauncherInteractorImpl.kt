package com.github.scrobot.coctaildb.business.interactor.launcher

import com.github.scrobot.coctaildb.business.repository.DrinksRepository
import com.github.scrobot.coctaildb.business.repository.FilterRepository

class LauncherInteractorImpl(
    private val drinksRepository: DrinksRepository,
    private val categoriesRepository: FilterRepository
) {

    fun loadCategories() = drinksRepository.loadCategories()

    fun loadDrinks() = categoriesRepository.selectCategories()
        .toFlowable()
        .flatMapIterable { it }
        .flatMap { drinksRepository.findDrinksByCategory(it.categoryId).toFlowable() }
        .doOnNext { drinksRepository.saveDrinks(it ?: emptyList()) }
        .toList()

}