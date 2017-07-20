package com.hawkeye.quotes.di

import android.app.Application
import com.hawkeye.quotes.MainApp
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by firta on 7/20/2017.
 * the dagger component for the application
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface ApplicationComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance fun application(app:Application):Builder
        fun build():ApplicationComponent
    }
    fun inject(app: MainApp)
}