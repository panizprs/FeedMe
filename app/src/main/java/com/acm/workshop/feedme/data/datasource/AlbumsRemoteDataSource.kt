package com.acm.workshop.feedme.data.datasource

import com.acm.workshop.feedme.data.model.Album
import io.reactivex.Single

interface AlbumsRemoteDataSource {
    fun getAlbums() : Single<List<Album>>

}