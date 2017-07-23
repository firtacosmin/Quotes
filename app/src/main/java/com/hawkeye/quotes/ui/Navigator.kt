package com.hawkeye.quotes.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.hawkeye.quotes.MainActivity
import com.hawkeye.quotes.R
import javax.inject.Inject

/**
 * Created by firta on 7/22/2017.
 * The class that will manage the navigation between the app screens
 */
class Navigator @Inject constructor(activity:MainActivity) {

    private var frgManager:FragmentManager
    private var contentID:Int = R.id.container


    init {
        frgManager = activity.supportFragmentManager
    }

    fun goToQuoteOfTheDay(){
        val f: Fragment = QuoteOfTheDayFragment()
        frgManager.beginTransaction()
                .replace(contentID, f)
                .commitAllowingStateLoss()
    }

    fun goToQuoteBrowse(){
        val f: Fragment = BrowseQuotesFragment()
        frgManager.beginTransaction()
                .replace(contentID, f)
                .commitAllowingStateLoss()
    }





}