package com.acm.workshop.feedme.app.ui.Albums

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.acm.workshop.feedme.domain.interactor.GetAlbumsUseCase
import com.acm.workshop.feedme.remote.api.AlbumsApi
import javax.inject.Inject

class AlbumsViewModelFactory @Inject constructor(private val albumsUseCase: GetAlbumsUseCase) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlbumsViewModel(albumsUseCase) as T
    }


}