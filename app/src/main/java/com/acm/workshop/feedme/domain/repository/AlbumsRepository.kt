package com.acm.workshop.feedme.domain.repository

import com.acm.workshop.feedme.data.model.Album
import io.reactivex.Single

interface AlbumsRepository {
    fun getAlbums() : Single<List<Album>>

}