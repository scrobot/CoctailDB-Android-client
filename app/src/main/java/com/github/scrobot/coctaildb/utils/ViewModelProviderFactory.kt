package com.github.scrobot.coctaildb.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ViewModelProviderFactory<V : ViewModel>(private val viewModel: V) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModel::class.java)) {
            return viewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}