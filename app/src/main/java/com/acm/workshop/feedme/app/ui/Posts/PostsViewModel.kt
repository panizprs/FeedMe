package com.acm.workshop.feedme.app.ui.Posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acm.workshop.feedme.data.model.Post
import com.acm.workshop.feedme.remote.api.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostsViewModel @Inject constructor(private val postApi: PostApi)  : ViewModel(){
    private val disposables = CompositeDisposable()

    private val _showPosts = MutableLiveData<List<Post>>()
    val showPosts : LiveData<List<Post>> = _showPosts


    fun getPosts() {
        postApi.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({list ->
                println(list.size)
                //                println(list)
                _showPosts.value = list
            },{
                println("error: $it")
            }).addTo(disposables)
    }

    fun onDestroy(){
        if(!disposables.isDisposed)
            disposables.dispose()
    }
}