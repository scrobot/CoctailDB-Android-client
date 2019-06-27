package com.github.scrobot.coctaildb.ui.launcher

import android.os.Bundle
import com.github.scrobot.coctaildb.CocktailApplication
import com.github.scrobot.coctaildb.R
import com.github.scrobot.coctaildb.di.launcher.LauncherModule
import com.github.scrobot.coctaildb.presentation.launcher.LauncherViewModel
import com.github.scrobot.coctaildb.ui.BaseFragment
import dagger.android.support.AndroidSupportInjection

class LauncherFragment: BaseFragment<LauncherViewModel>() {

    override val layout: Int = R.layout.fragment_launcher

    override fun getViewModelClass() = LauncherViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CocktailApplication.component.plus(LauncherModule()).inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.startLoadingData()
    }

}