package com.acm.workshop.feedme.app.ui.Albums

import com.acm.workshop.feedme.data.model.Album

interface OnAlbumClickListener {

    fun onAlbumSelected(album: Album)
}