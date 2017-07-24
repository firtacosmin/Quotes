package com.hawkeye.quotes.di

import android.app.Application
import android.support.v4.app.Fragment
import com.hawkeye.quotes.MainActivity
import com.hawkeye.quotes.MainApp
import com.hawkeye.quotes.di.modules.AppModule
import com.hawkeye.quotes.di.modules.FirebaseModule
import com.hawkeye.quotes.di.modules.ViewModelsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by firta on 7/20/2017.
 * the dagger component for the application
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        FirebaseModule::class,
        MainActivityModule::class))
interface ApplicationComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance fun application(app:Application):Builder
        fun build():ApplicationComponent
    }
    fun inject(app: MainApp)
//    fun inject(activity:MainActivity)
//    fun inject(fragment:Fragment)
}