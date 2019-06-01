package com.acm.workshop.feedme.app.ui.Albums

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.acm.workshop.feedme.remote.api.AlbumsApi
import javax.inject.Inject

class AlbumsViewModelFactory @Inject constructor(private val albumsApi: AlbumsApi) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlbumsViewModel(albumsApi) as T
    }


}