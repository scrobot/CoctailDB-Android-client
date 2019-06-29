package com.github.scrobot.coctaildb.ui.launcher

import android.os.Bundle
import androidx.lifecycle.Observer
import com.github.scrobot.coctaildb.CocktailApplication
import com.github.scrobot.coctaildb.R
import com.github.scrobot.coctaildb.di.launcher.LauncherModule
import com.github.scrobot.coctaildb.presentation.launcher.LauncherViewModel
import com.github.scrobot.coctaildb.presentation.launcher.LauncherViewModel.LoadingState.*
import com.github.scrobot.coctaildb.ui.BaseFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_launcher.*

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
            .observe(viewLifecycleOwner, Observer {
                vLoadingInfo.text = when(it) {
                    StartLoading ->  getString(R.string.launcher_start_loading)
                    is CategoryLoaded -> getString(R.string.launcher_category_loaded, it.sum)
                    is DrinksLoaded -> getString(R.string.launcher_drinks_loaded, it.category, it.progress, it.size)
                    FinishLoading -> getString(R.string.launcher_completed)
                }
            })
    }

}