package com.acm.workshop.feedme.domain.repository

import com.acm.workshop.feedme.data.model.Post
import io.reactivex.Single

interface PostsRepository{
    fun getLatest() : Single<List<Post>>

}