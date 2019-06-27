package com.github.scrobot.coctaildb.di.drinks

import com.github.scrobot.coctaildb.ui.drinks.DrinksFragment
import com.github.scrobot.coctaildb.ui.launcher.LauncherFragment
import dagger.Subcomponent

@Subcomponent(modules = [DrinksModule::class])
interface DrinksComponent {

    fun inject(fragment: DrinksFragment)

}