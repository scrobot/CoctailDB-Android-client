package com.github.scrobot.coctaildb.utils

import androidx.fragment.app.FragmentTransaction
import com.github.scrobot.coctaildb.R

object FragmentAnimationUtils {

    fun defaultScreenAnimation(fragmentTransaction: FragmentTransaction?) {
        fragmentTransaction?.setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
    }

}