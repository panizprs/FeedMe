package com.acm.workshop.feedme.domain.interactor

import com.acm.workshop.feedme.data.model.Photo
import com.acm.workshop.feedme.domain.executor.PostExecutorThread
import com.acm.workshop.feedme.domain.executor.UseCaseExecutorThread
import com.acm.workshop.feedme.domain.interactor.base.SingleUseCase
import com.acm.workshop.feedme.domain.repository.PhotosRepository
import io.reactivex.Single
import javax.inject.Inject


class GetPhotosUseCase @Inject constructor(
    private val photosRepository: PhotosRepository,
    postExecutorThread: PostExecutorThread,
    useCaseExecutorThread: UseCaseExecutorThread
) : SingleUseCase<GetPostsUseCase.None, List<Photo>>(postExecutorThread, useCaseExecutorThread) {
    override fun buildSingle(params: GetPostsUseCase.None): Single<List<Photo>> {
        return photosRepository.getLatest()
    }


}