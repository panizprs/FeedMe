package com.acm.workshop.feedme.domain.interactor.base

import com.acm.workshop.feedme.domain.executor.PostExecutorThread
import com.acm.workshop.feedme.domain.executor.UseCaseExecutorThread
import io.reactivex.Single

abstract class SingleUseCase<in Params, Result>(
    private val postExecutorThread: PostExecutorThread,
    private val useCaseExecutorThread: UseCaseExecutorThread
) : UseCase() {

    abstract fun buildSingle(params: Params): Single<Result>

    fun execute(
        params: Params,
        onSuccess: (result: Result) -> Unit,
        onFailure: (throwable :Throwable) -> Unit
    ) {
        buildSingle(params)
            .observeOn(postExecutorThread.scheduler)
            .subscribeOn(useCaseExecutorThread.scheduler)
            .subscribe({result ->
                onSuccess(result)
            }, {error ->
                onFailure(error)
            }).also { disposable ->
                add(disposable)
            }
    }


}