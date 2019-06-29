package com.github.scrobot.coctaildb.presentation.launcher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.scrobot.coctaildb.presentation.BaseViewModel
import com.github.scrobot.coctaildb.presentation.interactor.LauncherInteractor
import com.github.scrobot.coctaildb.presentation.launcher.LauncherViewModel.LoadingState.*
import com.github.scrobot.coctaildb.ui.Views
import com.github.scrobot.coctaildb.utils.SchedulersProvider
import com.github.scrobot.coctaildb.utils.delay
import com.github.scrobot.coctaildb.utils.seconds
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import ru.terrakok.cicerone.Router
import timber.log.Timber
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject

class LauncherViewModel @Inject constructor(
    private val interactor: LauncherInteractor,
    private val router: Router
): BaseViewModel() {

    private val loadingStateObserver = BehaviorRelay.create<LoadingState>()
    private var categorySize = AtomicInteger()
    private var loadingCounter = AtomicInteger()

    private val loadingStateLiveData = MutableLiveData<LoadingState>()

    init {
        loadingStateObserver.accept(StartLoading)
    }

    fun startLoadingData(): LiveData<LoadingState> {

        val loadDrinksFlowable = interactor.loadDrinks()
            .subscribeOn(SchedulersProvider.io())
            .observeOn(SchedulersProvider.ui())
            .map { it.first() }
            .doOnNext {
                loadingStateObserver.accept(DrinksLoaded(it.name, loadingCounter.incrementAndGet(), categorySize.get()))
                Timber.d("loadingCounter.get() == categorySize.get() -> ${loadingCounter.get() == categorySize.get()}")
                if(loadingCounter.get() == categorySize.get()) {
                    loadingStateObserver.accept(FinishLoading)
                }
            }
            .publish()

        loadingStateObserver
            .subscribeOn(SchedulersProvider.io())
            .observeOn(SchedulersProvider.ui())
            .subscribe(::handleLoadingState)
            .also { addDisposable(it) }

        interactor.loadCategories()
            .subscribeOn(SchedulersProvider.io())
            .observeOn(SchedulersProvider.ui())
            .delay(1.seconds())
            .map { it.size }
            .doOnSuccess { size ->
                Timber.d("on Success!!")
                categorySize.set(size)
                loadingStateObserver.accept(CategoryLoaded(size))
                loadDrinksFlowable.connect { disposable -> addDisposable(disposable) }
            }
            .subscribe()
            .also { addDisposable(it) }

        return loadingStateLiveData
    }

    private fun handleLoadingState(state: LoadingState) {
        loadingStateLiveData.value = state
        when(state) {
            FinishLoading -> {
                interactor.checkFirstLaunchingComplete()
                router.newRootScreen(Views.DrinksView())
            }
        }
    }

    sealed class LoadingState {
        object StartLoading : LoadingState()
        class CategoryLoaded(val sum: Int): LoadingState()
        class DrinksLoaded(val category: String, val progress: Int, val size: Int): LoadingState()
        object FinishLoading: LoadingState()
    }

}