package com.hawkeye.quotes.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.*
import com.hawkeye.quotes.BR
import com.hawkeye.quotes.R
import com.hawkeye.quotes.data.Quote
import com.hawkeye.quotes.databinding.FragmentQuoteOfTheDayBinding
import com.hawkeye.quotes.di.Injector
import com.hawkeye.quotes.utils.Consts
import java.util.*
import javax.inject.Inject


/**
 * Created by firta on 7/21/2017.
 *
 */
class QuoteOfTheDayFragment: Fragment(), Injector.Injectable {

    @Inject
    lateinit var dbRef:DatabaseReference

    lateinit var binder:FragmentQuoteOfTheDayBinding

    lateinit var quoteDbRef:Query
    var dayOfYear:Int = 0

    var childEvListener:ChildEventListener = object:ChildEventListener{
        override fun onChildMoved(p0: DataSnapshot?, p1: String?) {
        }

        override fun onChildChanged(data: DataSnapshot?, p1: String?) {
            bindQuoteFromSnapshot(data)
        }

        override fun onChildAdded(data: DataSnapshot?, p1: String?) {
            bindQuoteFromSnapshot(data)        }

        override fun onChildRemoved(p0: DataSnapshot?) {
        }

        override fun onCancelled(p0: DatabaseError?) {

        }
        fun onDataChange(data: DataSnapshot?) {
            bindQuoteFromSnapshot(data)
        }

    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

//        Injector.appComponent.inject(this)

        val calendar = Calendar.getInstance()
        dayOfYear = calendar.get(Calendar.DAY_OF_YEAR)

        binder = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_quote_of_the_day,container,false)
        quoteDbRef = dbRef.child(Consts.QUOTE_DB_CHILD).orderByChild("day")//.equalTo("$dayOfYear")


        quoteDbRef.addValueEventListener(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {

            }

            override fun onDataChange(data: DataSnapshot?) {
                val q:Query = quoteDbRef.equalTo(dayOfYear.toDouble())
                q.removeEventListener(childEvListener)
                q.addChildEventListener(childEvListener)
                bindQuoteFromSnapshot(data)
            }

        })


        return binder.root

    }


    private fun bindQuoteFromSnapshot(data: DataSnapshot?){
        var q:Quote? = data!!.getValue(Quote::class.java)
        if (q == null || q.value == null || q.value == "") {
            q = Quote("No Author", dayOfYear, "No Type", "No Value: ${dayOfYear}")
        }
        binder.quoteLayout.setVariable(BR.quote, q)
        binder.setVariable(BR.quote, q)
    }



}