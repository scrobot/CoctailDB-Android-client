package com.github.scrobot.coctaildb.di.launcher

import com.github.scrobot.coctaildb.ui.launcher.LauncherFragment
import dagger.Subcomponent

@Subcomponent(modules = [LauncherModule::class])
interface LauncherComponent {

    fun inject(launcherFragment: LauncherFragment)

}