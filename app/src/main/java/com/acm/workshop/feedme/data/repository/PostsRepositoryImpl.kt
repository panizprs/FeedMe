package com.acm.workshop.feedme.data.repository

import com.acm.workshop.feedme.data.datasource.PostsRemoteDataSource
import com.acm.workshop.feedme.data.model.Post
import com.acm.workshop.feedme.domain.repository.PostsRepository
import io.reactivex.Single

class PostsRepositoryImpl(
    private val dataSource: PostsRemoteDataSource
) : PostsRepository {
    override fun getLatest(): Single<List<Post>> {
        return dataSource.getLatest()
    }
}