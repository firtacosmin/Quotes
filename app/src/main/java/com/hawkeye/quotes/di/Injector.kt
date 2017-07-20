package com.hawkeye.quotes.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.hawkeye.quotes.MainApp
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

/**
 * Created by firta on 7/20/2017.
 * The class that will do the injections
 */
/**
 * Helper class to automatically inject fragments if they implement [Injectable].
 */
object Injector {
    fun init(app: MainApp) {
        DaggerApplicationComponent.builder().application(app)
                .build().inject(app)
        app
                .registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle) {
//                        handleActivity(activity)
                    }

                    override fun onActivityStarted(activity: Activity) {

                    }

                    override fun onActivityResumed(activity: Activity) {

                    }

                    override fun onActivityPaused(activity: Activity) {

                    }

                    override fun onActivityStopped(activity: Activity) {

                    }

                    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

                    }

                    override fun onActivityDestroyed(activity: Activity) {

                    }
                })
    }

//    private fun handleActivity(activity: Activity) {
//        if (activity is HasSupportFragmentInjector) {
//            AndroidInjection.inject(activity)
//        }
//        (activity as? FragmentActivity)?.supportFragmentManager?.registerFragmentLifecycleCallbacks(
//                object : FragmentManager.FragmentLifecycleCallbacks() {
//                    override fun onFragmentCreated(fm: FragmentManager?, f: Fragment?,
//                                                   savedInstanceState: Bundle?) {
//                        if (f is Injectable) {
//                            AndroidSupportInjection.inject(f!!)
//                        }
//                    }
//                }, true)
//    }
}
