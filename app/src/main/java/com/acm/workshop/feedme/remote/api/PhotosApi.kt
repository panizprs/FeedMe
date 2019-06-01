package com.acm.workshop.feedme.remote.api

import com.acm.workshop.feedme.data.model.Photo
import io.reactivex.Single
import retrofit2.http.GET

interface PhotosApi {

    @GET("/photos")
    fun getPhotos() : Single<List<Photo>>

}