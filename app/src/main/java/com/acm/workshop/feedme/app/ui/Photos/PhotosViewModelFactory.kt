package com.acm.workshop.feedme.app.ui.Photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.acm.workshop.feedme.domain.interactor.GetPhotosUseCase
import javax.inject.Inject

class PhotosViewModelFactory @Inject constructor(private val photosUseCase: GetPhotosUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PhotosViewModel(photosUseCase) as T
    }
}