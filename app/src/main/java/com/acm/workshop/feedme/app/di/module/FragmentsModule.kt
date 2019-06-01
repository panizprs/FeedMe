package com.acm.workshop.feedme.app.di.module

import com.acm.workshop.feedme.app.ui.Albums.AlbumsFragment
import com.acm.workshop.feedme.app.ui.Photos.PhotosFragment
import com.acm.workshop.feedme.app.ui.Posts.PostsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule{


    @ContributesAndroidInjector
    abstract fun albumsFragment() : AlbumsFragment


    @ContributesAndroidInjector
    abstract fun photosFragment() : PhotosFragment

    @ContributesAndroidInjector
    abstract fun postsFragment() : PostsFragment

}