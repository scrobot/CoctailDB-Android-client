package com.github.scrobot.coctaildb.ui

import com.github.scrobot.coctaildb.ui.drinks.DrinksFragment
import com.github.scrobot.coctaildb.ui.filter.FilterFragment
import com.github.scrobot.coctaildb.ui.launcher.LauncherFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Views {

    object LauncherView: SupportAppScreen() {
        override fun getFragment() = LauncherFragment()
    }

    object DrinksView: SupportAppScreen() {
        override fun getFragment() = DrinksFragment()
    }

    object FilterView: SupportAppScreen() {
        override fun getFragment() = FilterFragment()
    }

}