package com.acm.workshop.feedme.app.ui.Photos


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
import javax.inject.Inject


class PhotosFragment : Fragment() {

    private var albumId : Int? = null

    @Inject
    lateinit var viewModelFactory : PhotosViewModelFactory

    private val viewModel by lazy {
        ViewModelProviders.of(this@PhotosFragment, viewModelFactory)[PhotosViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MyApp.component.inject(this)

        albumId = arguments?.getInt(KEY_ALBUM_ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
//        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = GridLayoutManager(context, 3)

        viewModel.getPhotos(albumId)

        viewModel.photos.observe(this@PhotosFragment, Observer {photos->
            println("size: ${photos.size}")
//            println(photos)
            recyclerView.adapter = PhotosAdapter(photos)
        })

    }


    override fun onDestroy() {
        super.onDestroy()

        viewModel.onDestroy()
    }


    companion object {
        fun newInstance(albumId: Int) : PhotosFragment{
            return PhotosFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_ALBUM_ID, albumId)
                }
            }
        }

        const val KEY_ALBUM_ID = "album_id"
    }
}
