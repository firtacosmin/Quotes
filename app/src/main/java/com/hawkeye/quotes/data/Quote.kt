package com.hawkeye.quotes.data

import com.google.firebase.database.IgnoreExtraProperties

/**
 * Created by firta on 7/21/2017.
 * The class that defines a quote
 */
@IgnoreExtraProperties
class Quote()  {

    constructor(author:String, day:Int, type:String, value:String) : this() {
        this.author = author
        this.day = day
        this.type = type
        this.value = value
    }

    var author:String = ""
    var day:Int = 0
    var type:String = ""
    var value:String = ""


}