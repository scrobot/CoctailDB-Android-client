package com.github.scrobot.coctaildb

import android.app.Activity
import androidx.multidex.MultiDexApplication
import com.github.scrobot.coctaildb.di.DaggerCocktailApplicationComponent
import dagger.android.HasActivityInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class CocktailApplication: MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerCocktailApplicationComponent.create()
            .inject(this)
    }

    override fun activityInjector() = dispatchingActivityInjector

}