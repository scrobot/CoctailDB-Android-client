package com.github.scrobot.coctaildb.ui

import androidx.fragment.app.Fragment
import com.github.scrobot.coctaildb.ui.launcher.LauncherFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Views {

    object LauncherView: SupportAppScreen() {

        override fun getFragment() = LauncherFragment()

    }

}