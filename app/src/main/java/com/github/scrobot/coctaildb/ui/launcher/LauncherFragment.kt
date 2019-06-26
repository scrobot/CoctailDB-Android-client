package com.github.scrobot.coctaildb.ui.launcher

import android.os.Bundle
import com.github.scrobot.coctaildb.R
import com.github.scrobot.coctaildb.presentation.launcher.LauncherViewModel
import com.github.scrobot.coctaildb.ui.BaseFragment

class LauncherFragment: BaseFragment<LauncherViewModel>() {

    override val layout: Int = R.layout.fragment_launcher

    override fun getViewModelClass() = LauncherViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

}