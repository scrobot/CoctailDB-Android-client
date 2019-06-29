package com.github.scrobot.coctaildb.business.interactor.launcher

import com.github.scrobot.coctaildb.business.model.DrinkPreview
import com.github.scrobot.coctaildb.business.repository.DrinksRepository
import com.github.scrobot.coctaildb.business.repository.FilterRepository
import com.github.scrobot.coctaildb.presentation.interactor.LauncherInteractor
import com.github.scrobot.coctaildb.utils.PreferenceManager
import com.github.scrobot.coctaildb.utils.SchedulersProvider
import javax.inject.Inject

class LauncherInteractorImpl @Inject constructor(
    private val drinksRepository: DrinksRepository,
    private val categoriesRepository: FilterRepository,
    private val preferenceManager: PreferenceManager
): LauncherInteractor {

    override fun loadCategories() = drinksRepository.loadCategories()

    override fun loadDrinks() = categoriesRepository.selectCategories()
        .flatMapIterable { it }
        .map { it.categoryId }
        .flatMap { categoryId ->
            drinksRepository
                .findDrinksByCategory(categoryId)
                .toFlowable()
                .flatMapIterable { it }
                .map { DrinkPreview(it.id, it.name, it.thumb, categoryId) }
                .toList()
                .toFlowable()
        }
        .observeOn(SchedulersProvider.newThread())
        .doOnNext { drinksRepository.saveDrinks(it ?: emptyList()) }

    override fun checkFirstLaunchingComplete() {
        preferenceManager.firstTimeLaunched()
    }
}