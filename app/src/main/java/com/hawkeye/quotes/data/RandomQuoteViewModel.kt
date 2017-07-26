package com.hawkeye.quotes.data

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.google.firebase.database.*
import com.hawkeye.quotes.utils.Consts
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 * Created by firta on 7/26/2017.
 * The ViewModel that will work with the random quotes
 */
class RandomQuoteViewModel @Inject constructor(var dbRef: DatabaseReference, app: Application): AndroidViewModel(app){
    val TAG:String = "RandomQuoteViewModel"


    var randomQuote: MutableLiveData<Quote>
    lateinit var randomQuoteDbRef: Query
    var sequence:MutableList<String> = ArrayList<String>()
    var initialSequence:MutableList<String> = ArrayList<String>()
    var currentKey:String = "0"
    var random = Random()


    init {
        randomQuote = MutableLiveData()
        dbRef.child(Consts.QUOTE_DB_CHILD).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {

            }

            override fun onDataChange(data: DataSnapshot?) {
                sequence.addAll((data?.value as HashMap<String, Any>).keys.toList() )
                initialSequence.addAll(sequence)
                generateNewRandomQuote()

            }

        })

    }


    fun randomQuote(): LiveData<Quote> = randomQuote

    fun generateNewRandomQuote(){
        val position = random.nextInt(sequence.size)
        currentKey = sequence[position]
        sequence.removeAt(position)

        if ( sequence.isEmpty() ){
            /*if reached the end of the list then repopulate the list with the initial values*/
            sequence.addAll(initialSequence)
        }

        randomQuoteDbRef = dbRef.child(Consts.QUOTE_DB_CHILD).child(currentKey)
        randomQuoteDbRef.addListenerForSingleValueEvent(object:ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                Log.d(TAG,"randomQuoteDbRef::onCancelled");
            }

            override fun onDataChange(quote: DataSnapshot?) {
                Log.d(TAG,"randomQuoteDbRef::onDataChange");

                randomQuote.postValue( quote?.getValue(Quote::class.java) )

            }

        })
    }

}