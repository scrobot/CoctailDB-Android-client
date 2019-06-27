package com.github.scrobot.coctaildb.di.filter

import com.github.scrobot.coctaildb.ui.drinks.DrinksFragment
import com.github.scrobot.coctaildb.ui.filter.FilterFragment
import com.github.scrobot.coctaildb.ui.launcher.LauncherFragment
import dagger.Subcomponent

@Subcomponent(modules = [FilterModule::class])
interface FilterComponent {

    fun inject(fragment: FilterFragment)

}