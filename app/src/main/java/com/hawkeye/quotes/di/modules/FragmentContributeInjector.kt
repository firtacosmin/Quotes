package com.hawkeye.quotes.di.modules

import com.hawkeye.quotes.ui.BrowseQuotesFragment
import com.hawkeye.quotes.ui.QuoteOfTheDayFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by firta on 7/22/2017.
 *
 */
@Module
abstract class FragmentContributeInjector {
    @ContributesAndroidInjector
    abstract fun contributeQuoteOfTheDay():QuoteOfTheDayFragment
    @ContributesAndroidInjector
    abstract fun contributeBrowseQuote():BrowseQuotesFragment

}