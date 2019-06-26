package com.github.scrobot.coctaildb.di.modules.common

import android.app.Application
import android.content.Context
import com.github.scrobot.coctaildb.CocktailApplication
import dagger.Provides
import javax.inject.Singleton
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: Application): Context

}