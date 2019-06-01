package com.acm.workshop.feedme.app.ui.Photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acm.workshop.feedme.R
import com.acm.workshop.feedme.data.model.Photo

class PhotosAdapter(private val photos: List<Photo>) : RecyclerView.Adapter<PhotosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo_item,parent, false)
        return PhotosViewHolder(view)
    }

    override fun getItemCount() = photos.size


    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(photos[position])
    }
}