package com.github.scrobot.coctaildb.di.modules.launcher

import com.github.scrobot.coctaildb.ui.launcher.LauncherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LauncherModule {

    @ContributesAndroidInjector(modules = [
        LauncherFragmentModule::class
    ])
    abstract fun bind(): LauncherFragment


}