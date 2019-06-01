package com.acm.workshop.feedme.domain.interactor

import com.acm.workshop.feedme.data.model.Post
import com.acm.workshop.feedme.data.repository.PostsRepositoryImpl
import com.acm.workshop.feedme.domain.executor.PostExecutorThread
import com.acm.workshop.feedme.domain.executor.UseCaseExecutorThread
import com.acm.workshop.feedme.domain.interactor.base.SingleUseCase
import com.acm.workshop.feedme.domain.repository.PostsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postsRepository: PostsRepository,
    postExecutorThread: PostExecutorThread,
    useCaseExecutorThread: UseCaseExecutorThread
) : SingleUseCase<GetPostsUseCase.None, List<Post>>(postExecutorThread, useCaseExecutorThread) {
    override fun buildSingle(params: None): Single<List<Post>> {
        return postsRepository.getLatest()
    }

    class None
}