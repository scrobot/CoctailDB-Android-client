package com.github.scrobot.coctaildb.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.github.scrobot.coctaildb.Constants
import com.github.scrobot.coctaildb.Constants.PREFERENCES

class PreferenceManagerHelper(context: Context): PreferenceManager {

    private val preferences = context.getSharedPreferences(PREFERENCES.NAME, MODE_PRIVATE)

    override fun isFirstLaunch(): Boolean = preferences.getBoolean(PREFERENCES.IS_FIRST_LAUNCH, true)

    override fun firstTimeLaunched() {
        with(preferences.edit()) {
            putBoolean(PREFERENCES.IS_FIRST_LAUNCH, false)
            apply()
        }
    }
}

interface PreferenceManager {

    fun isFirstLaunch(): Boolean
    fun firstTimeLaunched()

}