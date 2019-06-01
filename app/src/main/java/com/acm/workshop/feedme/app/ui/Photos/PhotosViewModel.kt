package com.acm.workshop.feedme.app.ui.Photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acm.workshop.feedme.data.model.Photo
import com.acm.workshop.feedme.remote.PhotosApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PhotosViewModel @Inject constructor(private val photosApi: PhotosApi) : ViewModel(){

    private val _photos = MutableLiveData<List<Photo>>()
    val photos : LiveData<List<Photo>> = _photos

    val disposables = CompositeDisposable()

    fun getPhotos(albumId: Int?){
        photosApi.getPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ photos ->
                if(albumId == null)
                    _photos.value = photos
                else
                    _photos.value = photos.filter { photo -> photo.albumId != null && photo.albumId == albumId }
            },{
                println("error $it")
            }).addTo(disposables)
    }

    fun onDestroy(){
        if(!disposables.isDisposed)
            disposables.dispose()
    }
}