package com.github.scrobot.coctaildb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.scrobot.coctaildb.CocktailApplication
import com.github.scrobot.coctaildb.R
import com.github.scrobot.coctaildb.utils.FragmentAnimationUtils
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Replace
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val navigationHolder by lazy { CocktailApplication.component.navigationHolder() }

    private val hostedFragment
        get() = supportFragmentManager.findFragmentById(R.id.fragment) as BaseFragment<*>?

    private val navigator: Navigator = object : SupportAppNavigator(this, R.id.fragment) {
        override fun setupFragmentTransaction(
            command: Command?,
            currentFragment: Fragment?,
            nextFragment: Fragment?,
            fragmentTransaction: FragmentTransaction?
        ) {
            Timber.d("current: $currentFragment -> next: $nextFragment")
            FragmentAnimationUtils.defaultScreenAnimation(fragmentTransaction)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            navigator.applyCommands(arrayOf(Replace(Views.LauncherView)))
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        Timber.d(hostedFragment.toString())
        hostedFragment?.onBackPressed()
    }
}
