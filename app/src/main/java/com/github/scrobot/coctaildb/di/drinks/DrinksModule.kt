package com.github.scrobot.coctaildb.di.drinks

import com.github.scrobot.coctaildb.business.interactor.drinks.DrinksInteractorImpl
import com.github.scrobot.coctaildb.business.repository.DrinksRepository
import com.github.scrobot.coctaildb.presentation.drinks.DrinksViewModel
import com.github.scrobot.coctaildb.presentation.interactor.DrinksInteractor
import com.github.scrobot.coctaildb.presentation.launcher.LauncherViewModel
import com.github.scrobot.coctaildb.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
class DrinksModule {

    @Provides
    fun provideInteractor(drinksRepository: DrinksRepository): DrinksInteractor
            = DrinksInteractorImpl(drinksRepository)

    @Provides
    fun provideViewModel(interactor: DrinksInteractor, router: Router) = DrinksViewModel(interactor, router)

    @Provides
    fun provideViewModelProvider(viewModel: DrinksViewModel) = ViewModelProviderFactory(viewModel)

}