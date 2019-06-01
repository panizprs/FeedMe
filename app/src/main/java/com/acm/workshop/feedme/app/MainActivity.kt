package com.acm.workshop.feedme.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.acm.workshop.feedme.R
import com.acm.workshop.feedme.app.ui.Albums.AlbumsFragment
import com.acm.workshop.feedme.app.ui.Photos.PhotosFragment
import com.acm.workshop.feedme.app.ui.Posts.PostsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyApp.component.inject(this)


//        supportFragmentManager.beginTransaction()
//            .replace(R.id.content_frame, PostsFragment())
//            .commit()

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.content_frame, PhotosFragment())
//            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, AlbumsFragment())
            .commit()
    }



}
