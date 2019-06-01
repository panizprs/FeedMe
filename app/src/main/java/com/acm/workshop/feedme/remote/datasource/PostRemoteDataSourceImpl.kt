package com.acm.workshop.feedme.remote.datasource

import com.acm.workshop.feedme.data.datasource.PostRemoteDataSource
import com.acm.workshop.feedme.data.model.Post
import com.acm.workshop.feedme.remote.api.PostApi
import io.reactivex.Single

class PostRemoteDataSourceImpl(private val postApi: PostApi) : PostRemoteDataSource{
    override fun getLatest(): Single<List<Post>> {
        return postApi.getPosts()
    }


}