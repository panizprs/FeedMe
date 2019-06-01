package com.acm.workshop.feedme.app.ui.Photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.acm.workshop.feedme.remote.api.PhotosApi
import javax.inject.Inject

class PhotosViewModelFactory @Inject constructor(private val photosApi: PhotosApi) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PhotosViewModel(photosApi) as T
    }
}