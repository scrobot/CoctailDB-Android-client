package com.github.scrobot.coctaildb.presentation.launcher

import androidx.lifecycle.ViewModel
import com.github.scrobot.coctaildb.presentation.BaseViewModel
import com.github.scrobot.coctaildb.presentation.interactor.LauncherInteractor
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class LauncherViewModel @Inject constructor(
    private val interactor: LauncherInteractor,
    private val router: Router
): BaseViewModel() {



}