package com.hawkeye.quotes.data

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.hawkeye.quotes.utils.Consts
import java.util.*
import javax.inject.Inject

/**
 * Created by firta on 7/23/2017.
 *
 */
class QuoteViewModel @Inject constructor(dbRef: DatabaseReference, app:Application): AndroidViewModel(app) {



    var quoteOfTheDayDbRef:Query
    var quoteOfTheDayLiveData:MutableLiveData<Quote>

    var dayOfYear:Int = 0

    var quoteOfTheDayListener: ChildEventListener = object: ChildEventListener {
        override fun onChildMoved(p0: DataSnapshot?, p1: String?) {
        }

        override fun onChildChanged(data: DataSnapshot?, p1: String?) {
            sendNewQuoteOfTheDay(data)
        }

        override fun onChildAdded(data: DataSnapshot?, p1: String?) {
            sendNewQuoteOfTheDay(data)        }

        override fun onChildRemoved(p0: DataSnapshot?) {
        }

        override fun onCancelled(p0: DatabaseError?) {

        }
        fun onDataChange(data: DataSnapshot?) {
            sendNewQuoteOfTheDay(data)
        }

    }

    init {

        quoteOfTheDayLiveData = MutableLiveData()

        val calendar = Calendar.getInstance()
        dayOfYear = calendar.get(Calendar.DAY_OF_YEAR)
        quoteOfTheDayDbRef = dbRef.child(Consts.QUOTE_DB_CHILD).orderByChild("day")//.equalTo("$dayOfYear")
        quoteOfTheDayDbRef.addValueEventListener(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {

            }

            override fun onDataChange(data: DataSnapshot?) {
                val q:Query = quoteOfTheDayDbRef.equalTo(dayOfYear.toDouble())
                q.removeEventListener(quoteOfTheDayListener)
                q.addChildEventListener(quoteOfTheDayListener)
                sendNewQuoteOfTheDay(data)
            }

        })

    }

    fun quoteOfTheDay():LiveData<Quote>{
        return quoteOfTheDayLiveData
    }


    private fun sendNewQuoteOfTheDay(data: DataSnapshot?) {
        var q:Quote? = data!!.getValue(Quote::class.java)
        if (q == null || q.value == "") {
            q = Quote("No Author", dayOfYear, "No Type", "No Value: ${dayOfYear}")
        }
        quoteOfTheDayLiveData.postValue(q)

    }



}