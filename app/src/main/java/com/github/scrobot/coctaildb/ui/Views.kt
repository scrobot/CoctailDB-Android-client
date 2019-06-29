package com.github.scrobot.coctaildb.ui

import com.github.scrobot.coctaildb.ui.drinks.DrinksFragment
import com.github.scrobot.coctaildb.ui.filter.FilterFragment
import com.github.scrobot.coctaildb.ui.launcher.LauncherFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Views {

    object LauncherView: SupportAppScreen() {
        override fun getFragment() = LauncherFragment()
    }

    class DrinksView(private val createNew: Boolean = false): SupportAppScreen() {
        override fun getFragment() = if(createNew) DrinksFragment() else DrinksFragment.getInstance()
    }

    object FilterView: SupportAppScreen() {
        override fun getFragment() = FilterFragment()
    }

}