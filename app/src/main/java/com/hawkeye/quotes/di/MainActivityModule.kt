package com.hawkeye.quotes.di

import com.hawkeye.quotes.MainActivity
import com.hawkeye.quotes.di.modules.FragmentContributeInjector
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by firta on 7/20/2017.
 * The module for the main activity
 */
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(FragmentContributeInjector::class))
    abstract fun contributeMainActivity(): MainActivity

}