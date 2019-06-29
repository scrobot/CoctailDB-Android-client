package com.github.scrobot.coctaildb.data.repository.drinks

import com.github.scrobot.coctaildb.business.model.Drink
import com.github.scrobot.coctaildb.business.model.DrinkPreview
import com.github.scrobot.coctaildb.business.repository.DrinksRepository
import com.github.scrobot.coctaildb.data.api.API
import com.github.scrobot.coctaildb.data.db.dao.CategoriesDAO
import com.github.scrobot.coctaildb.data.db.dao.DrinksDAO
import io.reactivex.Completable
import javax.inject.Inject

class DrinksRepositoryImpl @Inject constructor(
    private val api: API,
    private val categoriesDAO: CategoriesDAO,
    private val drinksDAO: DrinksDAO
): DrinksRepository {

    override fun saveDrinks(drinks: List<DrinkPreview>) {
        drinksDAO.insertDrinks(drinks)
    }

    override fun selectUncheckedCategories() = categoriesDAO.uncheckedCategories()

    override fun selectAllDrinks() = drinksDAO.selectDrinks()

    override fun loadCategories() = api.getCategories()
        .map { it["drinks"] }
        .toFlowable()
        .flatMapIterable { it }
        .map { it.apply { it.isChecked = true } }
        .toList()
        .doOnSuccess { categoriesDAO.insertCategories(it ?: emptyList()) }

    override fun findDrinksByCategory(category: String) = api.getDrinksByCategory(category)
        .map { it["drinks"] }
        .onErrorReturn { emptyList() }

    override fun requestDrinkDetails(id: String) = api.getDrinkDetails(id)
        .map { it["drinks"]?.firstOrNull() ?: Drink() }
        .onErrorReturn { Drink() }

}