package com.hawkeye.quotes.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hawkeye.quotes.di.Injector

/**
 * Created by firta on 7/22/2017.
 * the fragment that will print a quote randomly
 */
class BrowseQuotesFragment : Fragment(), Injector.Injectable {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}