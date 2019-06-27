package com.github.scrobot.coctaildb

import androidx.multidex.MultiDexApplication
import com.github.scrobot.coctaildb.di.CocktailApplicationComponent
import com.github.scrobot.coctaildb.di.DaggerCocktailApplicationComponent

class CocktailApplication: MultiDexApplication() {

    companion object {
        var instance: CocktailApplication? = null
        lateinit var component: CocktailApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerCocktailApplicationComponent.create().apply { inject(this@CocktailApplication) }

        instance = this
    }

}