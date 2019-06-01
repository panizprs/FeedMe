package com.acm.workshop.feedme.remote.datasource

import com.acm.workshop.feedme.data.datasource.PostsRemoteDataSource
import com.acm.workshop.feedme.data.model.Post
import com.acm.workshop.feedme.remote.api.PostApi
import io.reactivex.Single

class PostsRemoteDataSourceImpl(private val postApi: PostApi) : PostsRemoteDataSource{
    override fun getLatest(): Single<List<Post>> {
        return postApi.getPosts()
    }


}