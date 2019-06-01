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
) : SingleUseCase<Int?, List<Photo>>(postExecutorThread, useCaseExecutorThread) {
//    params -> albumId
    override fun buildSingle(params: Int?): Single<List<Photo>> {
        val photos = photosRepository.getLatest()
        return if (params == null)
            photos
        else {
            photos.map { photosList ->
                photosList.filter { photo ->
                    photo.albumId != null && photo.albumId == params
                }
            }
        }
    }


}