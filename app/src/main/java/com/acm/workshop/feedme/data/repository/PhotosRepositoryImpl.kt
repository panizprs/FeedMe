package com.acm.workshop.feedme.data.repository

import com.acm.workshop.feedme.data.datasource.PhotosRemoteDataSource
import com.acm.workshop.feedme.data.model.Photo
import com.acm.workshop.feedme.domain.repository.PhotosRepository
import io.reactivex.Single

class PhotosRepositoryImpl(private val photosDataSource: PhotosRemoteDataSource) : PhotosRepository{
    override fun getLatest(): Single<List<Photo>> {
        return photosDataSource.getLatest()
    }


}