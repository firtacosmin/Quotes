package com.hawkeye.quotes.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.hawkeye.quotes.data.QuoteViewModel
import com.hawkeye.quotes.data.QuoteViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by firta on 7/24/2017.
 * the module that defines the viewmodel that will be used and placed into the map
 */
@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(QuoteViewModel::class)
    abstract fun quoteViewModel(quoteViewModel: QuoteViewModel):ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: QuoteViewModelFactory):ViewModelProvider.Factory

}