package com.github.scrobot.coctaildb.presentation.drinks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.scrobot.coctaildb.business.model.DrinkPreview
import com.github.scrobot.coctaildb.presentation.BaseViewModel
import com.github.scrobot.coctaildb.presentation.interactor.DrinksInteractor
import com.github.scrobot.coctaildb.ui.Views
import com.github.scrobot.coctaildb.utils.SchedulersProvider
import ru.terrakok.cicerone.Router
import timber.log.Timber

class DrinksViewModel(
    private val interactor: DrinksInteractor,
    private val router: Router
) : BaseViewModel() {

    private val drinksLiveData = MutableLiveData<Map<String, List<DrinkPreview>>>()
    private val filterLiveData = MutableLiveData<Boolean>()

    fun observeFilterState(): LiveData<Boolean> {
        interactor.haveAnyActiveFilter()
            .subscribeOn(SchedulersProvider.io())
            .observeOn(SchedulersProvider.ui())
            .subscribe { filterLiveData.value = it }
            .also { addDisposable(it) }

        return filterLiveData
    }

    fun observeDrinks(): LiveData<Map<String, List<DrinkPreview>>> {
        interactor.loadDrinks()
            .subscribeOn(SchedulersProvider.io())
            .observeOn(SchedulersProvider.ui())
            .map { Timber.d(it.toString()); it.groupBy { preview -> preview.category } }
            .subscribe(drinksLiveData::postValue)
            .also { addDisposable(it) }

        return drinksLiveData
    }

    override fun backPressAction() {
        super.backPressAction()
        router.exit()
    }

    fun navigateToFilter() {
        router.navigateTo(Views.FilterView)
    }
}