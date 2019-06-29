package com.github.scrobot.coctaildb.ui.filter

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.scrobot.coctaildb.CocktailApplication
import com.github.scrobot.coctaildb.R
import com.github.scrobot.coctaildb.di.filter.FilterModule
import com.github.scrobot.coctaildb.presentation.filter.FilterViewModel
import com.github.scrobot.coctaildb.ui.BaseFragment
import com.github.scrobot.coctaildb.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_filter.*
import timber.log.Timber

class FilterFragment: BaseFragment<FilterViewModel>(), FilterListChangesListener {

    override val layout: Int = R.layout.fragment_filter

    override fun getViewModelClass() = FilterViewModel::class.java

    private val filterAdapter by lazy { FilterAdapter(this) }

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

        with(vApply) {
            isEnabled = false

            setOnClickListener {
                viewModel.saveFilter(filterAdapter.getFilterChanges())
            }

            viewModel.observeUpdateStatus()
                .observe(viewLifecycleOwner, Observer {
                    when(it) {
                        FilterViewModel.FilterUpdate.SUCCESS -> {
                            Toast.makeText(context, getString(R.string.filter_updated_success), Toast.LENGTH_SHORT).show()
                            filterAdapter.updateOldList()
                            isEnabled = false
                        }
                        FilterViewModel.FilterUpdate.ERROR ->
                            Toast.makeText(context, getString(R.string.filter_updated_error), Toast.LENGTH_SHORT).show()
                        else -> Timber.d("Update status observer init")
                    }
                })
        }

        viewModel.observeCategories()
            .observe(viewLifecycleOwner, Observer {
                filterAdapter.load(it)
            })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun isFilterChanges(haveDifference: Boolean) {
        vApply.isEnabled = !haveDifference
    }
}