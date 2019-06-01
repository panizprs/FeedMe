package com.acm.workshop.feedme.remote.api

import com.acm.workshop.feedme.data.model.Album
import io.reactivex.Single
import retrofit2.http.GET

interface AlbumsApi {
    @GET("/albums")
    fun getAlbums() : Single<List<Album>>
}