package com.acm.workshop.feedme.app.ui.Albums

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acm.workshop.feedme.R
import com.acm.workshop.feedme.data.model.Album

class AlbumsAdapter(
    private val albums: List<Album>,
    private val onAlbumClickListener: OnAlbumClickListener
    ) : RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_album_item, parent, false)
        return AlbumsViewHolder(view)
    }

    override fun getItemCount() = albums.size

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        holder.bind(albums[position], onAlbumClickListener)
    }


    class AlbumsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val albumTX = itemView.findViewById<TextView>(R.id.album)
        fun bind(album: Album, onAlbumClickListener: OnAlbumClickListener) {
            albumTX.text = album.title

            itemView.setOnClickListener {
                onAlbumClickListener.onAlbumSelected(album)
            }
        }
    }
}
