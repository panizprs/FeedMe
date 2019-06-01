package com.acm.workshop.feedme.app.ui.Albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acm.workshop.feedme.data.model.Album
import com.acm.workshop.feedme.domain.interactor.GetAlbumsUseCase
import com.acm.workshop.feedme.remote.api.AlbumsApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AlbumsViewModel @Inject constructor(private val getAlbumsUseCase: GetAlbumsUseCase) : ViewModel(){

    private val _albums = MutableLiveData<List<Album>>()
    val albums : LiveData<List<Album>> = _albums

    private val _error = MutableLiveData<Throwable>()
    val error : LiveData<Throwable> = _error


    fun getAlbums(){
        getAlbumsUseCase.execute(GetAlbumsUseCase.None(), ::success, ::fail )

    }

    fun success(albums: List<Album>){
        _albums.value = albums
    }

    fun fail(throwable: Throwable){
        _error.value = throwable
    }


}