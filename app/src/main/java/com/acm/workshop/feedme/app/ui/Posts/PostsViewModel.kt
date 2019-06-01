package com.acm.workshop.feedme.app.ui.Posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acm.workshop.feedme.data.model.Post
import com.acm.workshop.feedme.domain.interactor.GetPostsUseCase
import javax.inject.Inject

class PostsViewModel @Inject constructor(private val getPostsUseCase: GetPostsUseCase)  : ViewModel(){


    private val _posts = MutableLiveData<List<Post>>()
    val posts : LiveData<List<Post>> = _posts

    private val _error = MutableLiveData<Throwable>()
    val error : LiveData<Throwable> = _error


    fun getPosts() {
        getPostsUseCase.execute(GetPostsUseCase.None(), ::success, ::fail)
    }

    private fun success(posts: List<Post>){
        _posts.value = posts
    }

    private fun fail(error: Throwable){
        _error.value = error
    }
}