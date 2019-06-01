package com.acm.workshop.feedme.app.ui.Albums


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.acm.workshop.feedme.R
import com.acm.workshop.feedme.app.MyApp
import com.acm.workshop.feedme.app.ui.Photos.PhotosFragment
import com.acm.workshop.feedme.data.model.Album
import javax.inject.Inject

class AlbumsFragment : Fragment() , OnAlbumClickListener{

    @Inject
    lateinit var albumsViewModelFactory : AlbumsViewModelFactory


    val albumsViewModel by lazy {
        ViewModelProviders.of(this, albumsViewModelFactory)[AlbumsViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MyApp.component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)

        recyclerView.layoutManager = GridLayoutManager(context, 3)

        albumsViewModel.getAlbums()

        albumsViewModel.albums.observe(this@AlbumsFragment, Observer {albums ->
            println(albums.size)
            println(albums)
            recyclerView.adapter = AlbumsAdapter(albums, this)
        })


    }


    override fun onDestroy() {
        super.onDestroy()
        albumsViewModel.onDestroy()
    }


    override fun onAlbumSelected(album: Album) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.content_frame, PhotosFragment.newInstance(album.id))
            ?.addToBackStack(null)
            ?.commit()
    }

}
