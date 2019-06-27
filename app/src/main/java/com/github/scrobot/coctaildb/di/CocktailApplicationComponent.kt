package com.github.scrobot.coctaildb.di

import android.app.Application
import com.github.scrobot.coctaildb.di.common.*
import com.github.scrobot.coctaildb.di.launcher.LauncherComponent
import com.github.scrobot.coctaildb.di.launcher.LauncherModule
import dagger.Component
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    DatabaseModule::class,
    RouterModule::class,
    RepositoryModule::class
])
interface CocktailApplicationComponent {

    fun inject(app: Application)

    fun plus(module: LauncherModule): LauncherComponent

    fun navigationHolder(): NavigatorHolder

    fun router(): Router

}