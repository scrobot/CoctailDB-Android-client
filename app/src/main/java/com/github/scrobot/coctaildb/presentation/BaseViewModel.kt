package com.github.scrobot.coctaildb.presentation

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel: ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun backPressAction() {}

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun addDisposable(disposable: Disposable) = compositeDisposable.addAll(disposable)

}