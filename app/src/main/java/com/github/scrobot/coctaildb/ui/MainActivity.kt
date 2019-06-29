package com.github.scrobot.coctaildb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.scrobot.coctaildb.CocktailApplication
import com.github.scrobot.coctaildb.R
import com.github.scrobot.coctaildb.utils.FragmentAnimationUtils
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Replace
import timber.log.Timber

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
            val view = if(CocktailApplication.component.preferenceManager().isFirstLaunch()) Views.LauncherView
                       else Views.DrinksView

            navigator.applyCommands(arrayOf(Replace(view)))
        }
    }

    override fun onResume() {
        super.onResume()
        navigationHolder.setNavigator(navigator)
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
