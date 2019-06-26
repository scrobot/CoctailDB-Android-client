package com.github.scrobot.coctaildb.di.modules.launcher

import com.github.scrobot.coctaildb.business.interactor.launcher.LauncherInteractorImpl
import com.github.scrobot.coctaildb.business.repository.DrinksRepository
import com.github.scrobot.coctaildb.business.repository.FilterRepository
import com.github.scrobot.coctaildb.presentation.interactor.LauncherInteractor
import dagger.Module
import dagger.Provides
import com.github.scrobot.coctaildb.presentation.launcher.LauncherViewModel
import com.github.scrobot.coctaildb.ui.Views
import com.github.scrobot.coctaildb.utils.ViewModelProviderFactory
import dagger.android.ContributesAndroidInjector
import ru.terrakok.cicerone.Router


@Module
class LauncherFragmentModule {

    @Provides
    fun provideInteractor(drinksRepository: DrinksRepository, categoriesRepository: FilterRepository): LauncherInteractor
            = LauncherInteractorImpl(drinksRepository, categoriesRepository)

    @Provides
    fun provideViewModel(interactor: LauncherInteractor, router: Router) = LauncherViewModel(interactor, router)

    @Provides
    fun provideViewModelProvider(viewModel: LauncherViewModel) = ViewModelProviderFactory(viewModel)

}