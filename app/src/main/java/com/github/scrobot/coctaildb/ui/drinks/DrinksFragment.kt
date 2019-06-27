package com.github.scrobot.coctaildb.ui.drinks

import android.os.Bundle
import com.github.scrobot.coctaildb.CocktailApplication
import com.github.scrobot.coctaildb.R
import com.github.scrobot.coctaildb.di.drinks.DrinksModule
import com.github.scrobot.coctaildb.presentation.drinks.DrinksViewModel
import com.github.scrobot.coctaildb.ui.BaseFragment

class DrinksFragment: BaseFragment<DrinksViewModel>() {
    override val layout: Int = R.layout.fragment_drinks

    override fun getViewModelClass() = DrinksViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CocktailApplication.component.plus(DrinksModule()).inject(this)
    }


}