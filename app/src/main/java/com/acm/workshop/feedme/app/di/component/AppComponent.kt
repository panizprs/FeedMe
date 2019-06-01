package com.acm.workshop.feedme.app.di.component

import com.acm.workshop.feedme.app.di.module.NetworkModule
import com.acm.workshop.feedme.app.di.module.AppModule
import com.acm.workshop.feedme.app.di.module.PhotosModule
import com.acm.workshop.feedme.app.di.module.PostsModule
import com.acm.workshop.feedme.app.ui.Albums.AlbumsFragment
import com.acm.workshop.feedme.app.ui.Photos.PhotosFragment
import com.acm.workshop.feedme.app.ui.Posts.PostsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        PostsModule::class,
        PhotosModule::class]
)
interface AppComponent {

    fun inject(fragment: PostsFragment)
    fun inject(fragment: PhotosFragment)
    fun inject(fragment: AlbumsFragment)
}