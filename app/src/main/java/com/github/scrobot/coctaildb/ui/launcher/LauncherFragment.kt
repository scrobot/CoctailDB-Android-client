package com.github.scrobot.coctaildb.ui.launcher

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.github.scrobot.coctaildb.presentation.launcher.LauncherViewModel
import com.github.scrobot.coctaildb.ui.BaseFragment
import com.github.scrobot.coctaildb.utils.ViewModelProviderFactory
import dagger.Provides
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class LauncherFragment: BaseFragment<LauncherViewModel>() {
    override val layout: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun getViewModelClass() = LauncherViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

}