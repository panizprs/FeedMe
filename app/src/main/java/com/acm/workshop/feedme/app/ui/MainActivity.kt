package com.acm.workshop.feedme.app.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.acm.workshop.feedme.R
import com.acm.workshop.feedme.app.ui.Albums.AlbumsFragment
import com.acm.workshop.feedme.app.ui.Photos.PhotosFragment
import com.acm.workshop.feedme.app.ui.Posts.PostsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.postsMenu ->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.content_frame, PostsFragment())
                    .commit()
            }
            R.id.photosMenu ->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.content_frame, PhotosFragment())
                    .commit()
            }
            R.id.albumsMenu ->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.content_frame, AlbumsFragment())
                    .commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }





}
