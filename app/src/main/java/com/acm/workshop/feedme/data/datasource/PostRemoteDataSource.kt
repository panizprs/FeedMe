package com.acm.workshop.feedme.data.datasource

import com.acm.workshop.feedme.data.model.Post
import io.reactivex.Single

interface PostRemoteDataSource {
    fun getLatest(): Single<List<Post>>

}