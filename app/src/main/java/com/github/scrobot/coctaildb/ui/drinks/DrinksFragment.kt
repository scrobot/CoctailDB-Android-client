package com.github.scrobot.coctaildb.ui.drinks

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.scrobot.coctaildb.CocktailApplication
import com.github.scrobot.coctaildb.R
import com.github.scrobot.coctaildb.di.drinks.DrinksModule
import com.github.scrobot.coctaildb.presentation.drinks.DrinksViewModel
import com.github.scrobot.coctaildb.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_drinks.*
import timber.log.Timber

class DrinksFragment: BaseFragment<DrinksViewModel>() {
    override val layout: Int = R.layout.fragment_drinks

    override fun getViewModelClass() = DrinksViewModel::class.java

    private val drinksAdapter = DrinksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CocktailApplication.component.plus(DrinksModule()).inject(this)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with(vToolbar) {
            title = getString(R.string.drinks_title)
            inflateMenu(R.menu.toolbar_menu)
            setOnMenuItemClickListener { onOptionsItemSelected(it) }
        }

        vDrinksList.layoutManager = LinearLayoutManager(context)
        vDrinksList.adapter = drinksAdapter

        viewModel.observeDrinks()
            .observe(this, Observer {
                Timber.d(it.toString())
                drinksAdapter.load(it)
            })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.action_filter -> viewModel.navigateToFilter()
        }
        return super.onOptionsItemSelected(item)
    }


}