package com.github.scrobot.coctaildb.di

import android.app.Application
import com.github.scrobot.coctaildb.di.modules.MainActivityModule
import dagger.Component

@Component(modules = [MainActivityModule::class])
interface CocktailApplicationComponent {

    fun inject(app: Application)

}