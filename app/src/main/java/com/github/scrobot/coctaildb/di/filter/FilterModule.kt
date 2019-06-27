package com.github.scrobot.coctaildb.di.filter

import com.github.scrobot.coctaildb.business.interactor.filter.FilterInteractorImpl
import com.github.scrobot.coctaildb.business.repository.FilterRepository
import com.github.scrobot.coctaildb.presentation.drinks.DrinksViewModel
import com.github.scrobot.coctaildb.presentation.filter.FilterViewModel
import com.github.scrobot.coctaildb.presentation.interactor.FilterInteractor
import com.github.scrobot.coctaildb.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
class FilterModule {

    @Provides
    fun provideInteractor(filterRepository: FilterRepository): FilterInteractor
            = FilterInteractorImpl(filterRepository)

    @Provides
    fun provideViewModel(interactor: FilterInteractor, router: Router) = FilterViewModel(interactor, router)

    @Provides
    fun provideViewModelProvider(viewModel: FilterViewModel) = ViewModelProviderFactory(viewModel)

}