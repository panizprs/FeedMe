package com.acm.workshop.feedme.app.di

import com.acm.workshop.feedme.app.MyApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val myApp: MyApp){

    @Provides
    @Singleton
    fun providesContext() = myApp.applicationContext
}