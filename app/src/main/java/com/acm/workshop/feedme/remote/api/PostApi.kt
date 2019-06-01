package com.acm.workshop.feedme.remote.api


import com.acm.workshop.feedme.data.model.Post
import io.reactivex.Single
import retrofit2.http.GET

interface PostApi{

    @GET("/posts")
    fun getPosts() : Single<List<Post>>

}

