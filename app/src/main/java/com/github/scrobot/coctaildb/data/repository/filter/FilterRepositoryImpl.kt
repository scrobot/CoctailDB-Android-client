package com.github.scrobot.coctaildb.data.repository.filter

import com.github.scrobot.coctaildb.business.model.DrinkCategory
import com.github.scrobot.coctaildb.business.repository.FilterRepository
import com.github.scrobot.coctaildb.data.db.dao.CategoriesDAO
import io.reactivex.Completable
import javax.inject.Inject

class FilterRepositoryImpl @Inject constructor(
    private val dao: CategoriesDAO
): FilterRepository {

    override fun selectCategories() = dao.selectCategories()
        .onErrorReturn { emptyList() }

    override fun updateCategories(list: List<DrinkCategory>) = Completable.fromAction {
        dao.updateCategories(list)
    }

}