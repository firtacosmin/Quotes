package com.hawkeye.quotes

import android.app.Activity
import android.app.Application
import com.google.firebase.database.DatabaseReference
import com.hawkeye.quotes.di.Injector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by firta on 7/20/2017.
 * the class for the main application
 */
class MainApp: Application(), HasActivityInjector {


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var db:DatabaseReference

    override fun onCreate() {
        super.onCreate()

        Injector.init(this);

    }


    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

}