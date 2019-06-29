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
    private val filterUpdateLiveData = MutableLiveData<FilterUpdate>()

    fun observeCategories(): LiveData<List<DrinkCategory>> {
        interactor.selectCategories()
            .subscribeOn(SchedulersProvider.io())
            .observeOn(SchedulersProvider.ui())
            .subscribe(categoriesLiveData::postValue)
            .also { addDisposable(it) }

        return categoriesLiveData
    }

    fun observeUpdateStatus(): LiveData<FilterUpdate> = filterUpdateLiveData

    fun saveFilter(categories: List<DrinkCategory>) {
        interactor.updateCategories(categories)
            .subscribeOn(SchedulersProvider.newThread())
            .observeOn(SchedulersProvider.ui())
            .doOnError { filterUpdateLiveData.value = FilterUpdate.ERROR }
            .subscribe { filterUpdateLiveData.value = FilterUpdate.SUCCESS }
            .also { addDisposable(it) }
    }

    override fun backPressAction() {
        super.backPressAction()
        router.exit()
    }

    enum class FilterUpdate {
        SUCCESS, ERROR
    }
}