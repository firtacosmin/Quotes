package com.hawkeye.quotes.ui

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hawkeye.quotes.BR
import com.hawkeye.quotes.R
import com.hawkeye.quotes.data.Quote
import com.hawkeye.quotes.data.QuoteViewModel
import com.hawkeye.quotes.data.QuoteViewModelFactory
import com.hawkeye.quotes.databinding.FragmentQuoteOfTheDayBinding
import com.hawkeye.quotes.di.Injector
import javax.inject.Inject


/**
 * Created by firta on 7/21/2017.
 *
 */
class QuoteOfTheDayFragment: LifecycleFragment(), Injector.Injectable {
    val TAG:String = "QuoteOfTheDayFragment";

    lateinit var viewModel:QuoteViewModel

    lateinit var binder:FragmentQuoteOfTheDayBinding

    @Inject
    lateinit var viewModelFactory: QuoteViewModelFactory



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binder = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_quote_of_the_day,container,false)


        viewModel = ViewModelProviders.of(this, viewModelFactory).get(QuoteViewModel::class.java)
        viewModel.quoteOfTheDay().observe(this, Observer<Quote>{quote ->

            Log.d("TAG","new quote:"+quote?.value)
            binder.quoteLayout.setVariable(BR.quote, quote)

        })

        return binder.root

    }




}