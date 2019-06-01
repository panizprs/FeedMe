package com.acm.workshop.feedme.app.di.module

import com.acm.workshop.feedme.app.MyApp
import com.acm.workshop.feedme.app.executor.BackgroundThread
import com.acm.workshop.feedme.app.executor.MainThread
import com.acm.workshop.feedme.domain.executor.PostExecutorThread
import com.acm.workshop.feedme.domain.executor.UseCaseExecutorThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val myApp: MyApp){

    @Provides
    @Singleton
    fun providesContext() = myApp.applicationContext


    @Provides
    fun provideMainThread() : PostExecutorThread = MainThread()

    @Provides
    fun provideBackgroundThread() : UseCaseExecutorThread = BackgroundThread()

}