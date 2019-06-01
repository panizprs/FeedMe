package com.acm.workshop.feedme.app.di

import com.acm.workshop.feedme.app.MainActivity
import com.acm.workshop.feedme.app.ui.Albums.AlbumsFragment
import com.acm.workshop.feedme.app.ui.Photos.PhotosFragment
import com.acm.workshop.feedme.app.ui.Posts.PostsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class , NetworkModule::class])
interface AppComponent{

    fun inject(mainActivity: MainActivity)
    fun inject(fragment: PostsFragment)
    fun inject(fragment: PhotosFragment)
    fun inject(fragment: AlbumsFragment)
}