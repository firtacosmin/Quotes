package com.hawkeye.quotes.di.modules

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by firta on 7/21/2017.
 *
 */
@Module
class FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseDB():DatabaseReference{
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        return FirebaseDatabase.getInstance().reference
    }



}