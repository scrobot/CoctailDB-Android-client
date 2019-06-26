package com.github.scrobot.coctaildb.di.subcomponents

import com.github.scrobot.coctaildb.di.modules.common.RouterModule
import com.github.scrobot.coctaildb.di.modules.launcher.LauncherModule
import com.github.scrobot.coctaildb.ui.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface MainActivitySubcomponent: AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory: AndroidInjector.Factory<MainActivity>
}