package com.github.scrobot.coctaildb.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.github.scrobot.coctaildb.presentation.BaseViewModel
import com.github.scrobot.coctaildb.utils.ViewModelProviderFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<T: BaseViewModel>: Fragment() {

    abstract val layout: Int

    @Inject
    lateinit var vmFactory: ViewModelProviderFactory<T>

    protected val viewModel by lazy { ViewModelProviders.of(this, vmFactory)[getViewModelClass()] }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(layout, null)

    abstract fun getViewModelClass(): Class<T>

    fun onBackPressed() {
        viewModel.backPressAction()
    }
}