package com.github.scrobot.coctaildb.presentation.drinks

import com.github.scrobot.coctaildb.presentation.BaseViewModel
import com.github.scrobot.coctaildb.presentation.interactor.DrinksInteractor
import ru.terrakok.cicerone.Router

class DrinksViewModel(
    private val interactor: DrinksInteractor,
    private val router: Router
) : BaseViewModel() {
}