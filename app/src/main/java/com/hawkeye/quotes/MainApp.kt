package com.hawkeye.quotes

import android.app.Application
import com.hawkeye.quotes.di.Injector

/**
 * Created by firta on 7/20/2017.
 * the class for the main application
 */
class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()

        Injector.init(this);

    }
}