package com.acm.workshop.feedme.domain.repository

import com.acm.workshop.feedme.data.model.Photo
import io.reactivex.Single

interface PhotosRepository{
    fun getLatest() : Single<List<Photo>>
}