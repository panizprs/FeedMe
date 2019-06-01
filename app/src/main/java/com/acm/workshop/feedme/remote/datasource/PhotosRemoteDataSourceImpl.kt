package com.acm.workshop.feedme.remote.datasource

import com.acm.workshop.feedme.data.datasource.PhotosRemoteDataSource
import com.acm.workshop.feedme.data.model.Photo
import com.acm.workshop.feedme.remote.api.PhotosApi
import io.reactivex.Single

class PhotosRemoteDataSourceImpl(private val photosApi: PhotosApi) : PhotosRemoteDataSource {
    override fun getLatest(): Single<List<Photo>> {
        return photosApi.getPhotos()
    }

}