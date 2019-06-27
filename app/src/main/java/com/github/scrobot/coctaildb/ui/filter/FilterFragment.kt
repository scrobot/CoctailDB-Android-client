package com.github.scrobot.coctaildb.ui.filter

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.scrobot.coctaildb.CocktailApplication
import com.github.scrobot.coctaildb.R
import com.github.scrobot.coctaildb.di.filter.FilterModule
import com.github.scrobot.coctaildb.presentation.filter.FilterViewModel
import com.github.scrobot.coctaildb.ui.BaseFragment
import com.github.scrobot.coctaildb.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_filter.*

class FilterFragment: BaseFragment<FilterViewModel>() {

    override val layout: Int = R.layout.fragment_filter

    override fun getViewModelClass() = FilterViewModel::class.java

    private val filterAdapter = FilterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        CocktailApplication.component.plus(FilterModule()).inject(this)
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        vToolbar.title = getString(R.string.filter_title)

        with(activity as MainActivity) {
            setSupportActionBar(vToolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }

        with(vFilterList) {
            layoutManager = LinearLayoutManager(context)
            adapter = filterAdapter
        }

        vApply.setOnClickListener {
            filterAdapter.getFilterChanges()
        }

        viewModel.observeCategories()
            .observe(this, Observer {
                filterAdapter.load(it)
            })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}