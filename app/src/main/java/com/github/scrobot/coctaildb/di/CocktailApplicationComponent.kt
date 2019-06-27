package com.github.scrobot.coctaildb.di

import android.app.Activity
import android.app.Application
import com.github.scrobot.coctaildb.di.common.*
import com.github.scrobot.coctaildb.di.drinks.DrinksComponent
import com.github.scrobot.coctaildb.di.drinks.DrinksModule
import com.github.scrobot.coctaildb.di.filter.FilterComponent
import com.github.scrobot.coctaildb.di.filter.FilterModule
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
    fun inject(activity: Activity)

    fun plus(module: LauncherModule): LauncherComponent
    fun plus(module: DrinksModule): DrinksComponent
    fun plus(module: FilterModule): FilterComponent

    fun navigationHolder(): NavigatorHolder

}