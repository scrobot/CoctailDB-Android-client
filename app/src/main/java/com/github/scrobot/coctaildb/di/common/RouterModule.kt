package com.github.scrobot.coctaildb.di.common

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Cicerone
import javax.inject.Singleton


@Module
class RouterModule {

    @Singleton
    @Provides
    fun provideCicerone() = Cicerone.create()

    @Singleton
    @Provides
    fun provideNavigatorHolder(cicerone: Cicerone<Router>) = cicerone.navigatorHolder

    @Singleton
    @Provides
    fun provideRouter(cicerone: Cicerone<Router>) = cicerone.router

}