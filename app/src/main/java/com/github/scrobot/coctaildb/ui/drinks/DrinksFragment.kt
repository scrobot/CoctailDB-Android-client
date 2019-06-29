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
import com.github.scrobot.coctaildb.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_drinks.*
import kotlinx.android.synthetic.main.fragment_drinks.vToolbar
import timber.log.Timber
import android.graphics.drawable.LayerDrawable





class DrinksFragment: BaseFragment<DrinksViewModel>() {
    override val layout: Int = R.layout.fragment_drinks

    override fun getViewModelClass() = DrinksViewModel::class.java

    private val drinksAdapter = DrinksAdapter()
    private var badge: BadgeDrawable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CocktailApplication.component.plus(DrinksModule()).inject(this)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with(vToolbar) {
            title = getString(R.string.drinks_title)
            (activity as MainActivity).setSupportActionBar(this)
            setOnMenuItemClickListener { onOptionsItemSelected(it) }
        }

        vDrinksList.layoutManager = LinearLayoutManager(context)
        vDrinksList.adapter = drinksAdapter

        viewModel.observeDrinks()
            .observe(viewLifecycleOwner, Observer {
                Timber.d(it.toString())
                drinksAdapter.load(it)
            })

        viewModel.observeFilterState()
            .observe(viewLifecycleOwner, Observer {
                badge?.setmWillDraw(it)
            })
    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        val menuItem = menu?.findItem(R.id.action_filter)
        val icon = menuItem?.icon as LayerDrawable

        // Reuse drawable if possible
        val reuse = icon.findDrawableByLayerId(R.id.action_filter)
        badge = if (reuse != null && reuse is BadgeDrawable) {
            reuse
        } else {
            BadgeDrawable(context)
        }

        icon.mutate()
        icon.setDrawableByLayerId(R.id.ic_group_count, badge)

        super.onPrepareOptionsMenu(menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.action_filter -> viewModel.navigateToFilter()
        }
        return super.onOptionsItemSelected(item)
    }


}