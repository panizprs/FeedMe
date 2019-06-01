package com.acm.workshop.feedme.app.ui.Albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acm.workshop.feedme.data.model.Album
import com.acm.workshop.feedme.remote.AlbumsApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AlbumsViewModel @Inject constructor(private val albumsApi : AlbumsApi) : ViewModel(){

    private val _albums = MutableLiveData<List<Album>>()
    val albums : LiveData<List<Album>> = _albums

    val disposables = CompositeDisposable()

    fun getAlbums(){
        albumsApi.getAlbums()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _albums.value = it
            },{
                println("error $it")
            }).addTo(disposables)

    }

    fun onDestroy(){
        if(!disposables.isDisposed)
            disposables.dispose()
    }
}