package com.github.scrobot.coctaildb.di.common

import android.app.Application
import android.content.Context
import com.github.scrobot.coctaildb.CocktailApplication
import com.github.scrobot.coctaildb.utils.PreferenceManager
import com.github.scrobot.coctaildb.utils.PreferenceManagerHelper
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(): Context = CocktailApplication.instance!!.baseContext

    @Provides
    fun providePreferenceManager(context: Context): PreferenceManager = PreferenceManagerHelper(context)

}