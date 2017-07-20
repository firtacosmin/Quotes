package com.hawkeye.quotes.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by firta on 7/20/2017.
 *
 */
@Module
class AppModule {

    @Provides @Singleton
    fun provideDatabaseReference():DatabaseReference{
        return FirebaseDatabase.getInstance().getReference();
    }

}