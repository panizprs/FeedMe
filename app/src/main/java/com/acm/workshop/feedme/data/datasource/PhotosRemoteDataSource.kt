package com.acm.workshop.feedme.data.datasource

import com.acm.workshop.feedme.data.model.Photo
import io.reactivex.Single

interface PhotosRemoteDataSource{
    fun getLatest() : Single<List<Photo>>

}