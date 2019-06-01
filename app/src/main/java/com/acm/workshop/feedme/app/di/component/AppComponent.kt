package com.acm.workshop.feedme.app.di.component

import com.acm.workshop.feedme.app.FeedMeApp
import com.acm.workshop.feedme.app.di.module.*
import com.acm.workshop.feedme.app.ui.Photos.PhotosFragment
import com.acm.workshop.feedme.app.ui.Posts.PostsFragment
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        FragmentsModule::class,
        NetworkModule::class,
        PostsModule::class,
        PhotosModule::class,
        AlbumsModule::class
    ]
)
interface AppComponent : AndroidInjector<FeedMeApp> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<FeedMeApp>
}

