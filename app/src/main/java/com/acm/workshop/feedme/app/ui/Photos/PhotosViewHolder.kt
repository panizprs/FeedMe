package com.acm.workshop.feedme.app.ui.Photos

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acm.workshop.feedme.R
import com.acm.workshop.feedme.data.model.Photo
import com.squareup.picasso.Picasso

class PhotosViewHolder(view: View) : RecyclerView.ViewHolder(view){
//    val tx = view.findViewById<TextView>(R.id.tx)
    val image = view.findViewById<ImageView>(R.id.image)

    fun bind(photo: Photo){
//        tx.text = photo.title

        Picasso.get().load(photo.thumbnailUrl).into(image)
    }

}