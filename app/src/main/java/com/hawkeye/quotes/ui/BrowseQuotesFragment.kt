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
import android.widget.Toast
import com.hawkeye.quotes.BR
import com.hawkeye.quotes.R
import com.hawkeye.quotes.data.Quote
import com.hawkeye.quotes.data.QuoteViewModel
import com.hawkeye.quotes.data.QuoteViewModelFactory
import com.hawkeye.quotes.data.RandomQuoteViewModel
import com.hawkeye.quotes.databinding.FragmentBrowseQuotesBinding
import com.hawkeye.quotes.di.Injector
import javax.inject.Inject

/**
 * Created by firta on 7/22/2017.
 * the fragment that will print a quote randomly
 */
class BrowseQuotesFragment : LifecycleFragment(), Injector.Injectable {

    @Inject
    lateinit var viewModelFactory: QuoteViewModelFactory

    private lateinit var binder: FragmentBrowseQuotesBinding

    private lateinit var viewModel: RandomQuoteViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binder = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_browse_quotes, container, false)
        binder.setVariable(BR.listener, this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RandomQuoteViewModel::class.java)
        viewModel.randomQuote().observe(this, Observer<Quote>{ quote ->

            Log.d("TAG","new quote:"+quote?.value)
            binder.quote.setVariable(BR.quote, quote)

        })

        return binder.root
    }


    fun refreshClicked(clickedView:View){

        viewModel.generateNewRandomQuote()

    }
}