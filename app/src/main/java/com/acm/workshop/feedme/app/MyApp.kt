package com.acm.workshop.feedme.app

import android.app.Application
import com.acm.workshop.feedme.app.di.AppComponent
import com.acm.workshop.feedme.app.di.AppModule
import com.acm.workshop.feedme.app.di.DaggerAppComponent

class MyApp : Application(){

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        lateinit var component : AppComponent

    }

}