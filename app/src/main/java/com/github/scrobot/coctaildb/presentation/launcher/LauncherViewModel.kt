package com.github.scrobot.coctaildb.presentation.launcher

import androidx.lifecycle.ViewModel
import com.github.scrobot.coctaildb.presentation.BaseViewModel
import com.github.scrobot.coctaildb.presentation.interactor.LauncherInteractor
import com.github.scrobot.coctaildb.utils.SchedulersProvider
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

class LauncherViewModel @Inject constructor(
    private val interactor: LauncherInteractor,
    private val router: Router
): BaseViewModel() {

    fun startLoadingData() {
        interactor.loadCategories()
            .subscribeOn(SchedulersProvider.io())
            .observeOn(SchedulersProvider.ui())
            .doOnSuccess {
                Timber.d("on Success!!")
            }
            .subscribe({
                Timber.d(it.toString())

                interactor.loadDrinks()
                    .subscribeOn(SchedulersProvider.io())
                    .observeOn(SchedulersProvider.ui())
                    .subscribe({
                        Timber.d(it?.toString())
                    }, Throwable::printStackTrace)
                    .also { addDisposable(it) }
            }, Throwable::printStackTrace)
            .also { addDisposable(it) }

    }

}