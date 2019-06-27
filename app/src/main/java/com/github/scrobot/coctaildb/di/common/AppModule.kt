package com.github.scrobot.coctaildb.di.common

import android.app.Application
import android.content.Context
import com.github.scrobot.coctaildb.CocktailApplication
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(): Context = CocktailApplication.instance!!.baseContext

}