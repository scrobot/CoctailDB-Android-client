package com.github.scrobot.coctaildb.di.modules.common

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Cicerone



@Module
class RouterModule {

    @Provides
    fun provideCicerone() = Cicerone.create()

    @Provides
    fun provideNavigatorHolder(cicerone: Cicerone<Router>) = cicerone.navigatorHolder

    @Provides
    fun provideRouter(cicerone: Cicerone<Router>) = cicerone.router

}