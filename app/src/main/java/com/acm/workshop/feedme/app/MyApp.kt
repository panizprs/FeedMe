package com.acm.workshop.feedme.app

import android.app.Application
import com.acm.workshop.feedme.app.di.component.AppComponent
import com.acm.workshop.feedme.app.di.module.AppModule
import com.acm.workshop.feedme.app.di.component.DaggerAppComponent

class MyApp : Application(){

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        lateinit var component : AppComponent

    }

}