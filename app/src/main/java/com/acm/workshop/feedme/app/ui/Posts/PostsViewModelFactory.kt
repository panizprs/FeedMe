package com.acm.workshop.feedme.app.ui.Posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.acm.workshop.feedme.remote.api.PostApi
import javax.inject.Inject

class PostsViewModelFactory @Inject constructor(private val postApi: PostApi) :  ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostsViewModel(postApi) as T
    }

}