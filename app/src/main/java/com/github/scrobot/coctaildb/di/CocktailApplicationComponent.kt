package com.github.scrobot.coctaildb.di

import android.app.Application
import com.github.scrobot.coctaildb.di.modules.common.AppModule
import com.github.scrobot.coctaildb.di.modules.common.DatabaseModule
import com.github.scrobot.coctaildb.di.modules.MainActivityModule
import com.github.scrobot.coctaildb.di.modules.common.NetworkModule
import com.github.scrobot.coctaildb.di.modules.common.RouterModule
import dagger.Component

@Component(modules = [
    AppModule::class,
    MainActivityModule::class,
    NetworkModule::class,
    DatabaseModule::class,
    RouterModule::class]
)
interface CocktailApplicationComponent {

    fun inject(app: Application)

}