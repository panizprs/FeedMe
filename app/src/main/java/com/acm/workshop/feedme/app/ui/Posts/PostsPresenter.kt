package com.acm.workshop.feedme.app.ui.Posts

import com.acm.workshop.feedme.remote.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostsPresenter @Inject constructor(private val postApi: PostApi) :
    PostsContract.Presenter {

    lateinit var view: PostsContract.View
    private val disposables = CompositeDisposable()

    override fun getPosts() {
        postApi.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({list ->
//                println(list)
                view.showPosts(list)
            },{
                println("error: $it")
            }).addTo(disposables)
    }

    override fun onDestroy(){
        if(!disposables.isDisposed)
            disposables.dispose()
    }

}