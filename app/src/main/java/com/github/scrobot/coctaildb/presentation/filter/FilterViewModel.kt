package com.github.scrobot.coctaildb.presentation.filter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.scrobot.coctaildb.business.model.DrinkCategory
import com.github.scrobot.coctaildb.presentation.BaseViewModel
import com.github.scrobot.coctaildb.presentation.interactor.FilterInteractor
import com.github.scrobot.coctaildb.utils.SchedulersProvider
import ru.terrakok.cicerone.Router

class FilterViewModel(
    private val interactor: FilterInteractor,
    private val router: Router
) : BaseViewModel() {

    private val categoriesLiveData = MutableLiveData<List<DrinkCategory>>()

    fun observeCategories(): LiveData<List<DrinkCategory>> {
        interactor.selectCategories()
            .subscribeOn(SchedulersProvider.io())
            .observeOn(SchedulersProvider.ui())
            .subscribe(categoriesLiveData::postValue)
            .also { addDisposable(it) }

        return categoriesLiveData
    }

    override fun backPressAction() {
        super.backPressAction()
        router.exit()
    }
}