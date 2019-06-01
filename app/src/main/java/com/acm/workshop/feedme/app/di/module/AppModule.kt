package com.acm.workshop.feedme.app.di.module

import com.acm.workshop.feedme.app.FeedMeApp
import com.acm.workshop.feedme.app.executor.BackgroundThread
import com.acm.workshop.feedme.app.executor.MainThread
import com.acm.workshop.feedme.domain.executor.PostExecutorThread
import com.acm.workshop.feedme.domain.executor.UseCaseExecutorThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule{

    @Provides
    @Singleton
    fun providesContext(feedMeApp: FeedMeApp) = feedMeApp.applicationContext


    @Provides
    fun provideMainThread() : PostExecutorThread = MainThread()

    @Provides
    fun provideBackgroundThread() : UseCaseExecutorThread = BackgroundThread()

}