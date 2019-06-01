package com.acm.workshop.feedme.app.ui.Posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.acm.workshop.feedme.domain.interactor.GetPostsUseCase
import com.acm.workshop.feedme.domain.repository.PostsRepository
import com.acm.workshop.feedme.remote.api.PostApi
import javax.inject.Inject

class PostsViewModelFactory @Inject constructor(private val getPostsUseCase: GetPostsUseCase) :  ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostsViewModel(getPostsUseCase) as T
    }

}