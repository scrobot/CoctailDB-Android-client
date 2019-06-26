package com.github.scrobot.coctaildb.di.modules

import com.github.scrobot.coctaildb.di.modules.common.RouterModule
import com.github.scrobot.coctaildb.di.modules.launcher.LauncherModule
import com.github.scrobot.coctaildb.di.subcomponents.MainActivitySubcomponent
import com.github.scrobot.coctaildb.ui.MainActivity
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [RouterModule::class, LauncherModule::class])
    internal abstract fun bindMainActivityInjectorFactory(factory: MainActivitySubcomponent.Factory): AndroidInjector.Factory<*>

}