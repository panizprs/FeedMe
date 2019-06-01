package com.acm.workshop.feedme.domain.interactor

import com.acm.workshop.feedme.data.model.Album
import com.acm.workshop.feedme.domain.executor.PostExecutorThread
import com.acm.workshop.feedme.domain.executor.UseCaseExecutorThread
import com.acm.workshop.feedme.domain.interactor.base.SingleUseCase
import com.acm.workshop.feedme.domain.repository.AlbumsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(
    private val albumRepository: AlbumsRepository,
    postExecutorThread: PostExecutorThread,
    useCaseExecutorThread: UseCaseExecutorThread
) : SingleUseCase<GetAlbumsUseCase.None, List<Album>>(postExecutorThread, useCaseExecutorThread) {
    override fun buildSingle(params: None): Single<List<Album>> {
        return albumRepository.getAlbums()
    }


    class None
}