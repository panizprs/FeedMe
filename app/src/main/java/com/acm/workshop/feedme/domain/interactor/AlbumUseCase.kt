package com.acm.workshop.feedme.domain.interactor

import com.acm.workshop.feedme.data.model.Photo

class AlbumUseCase {

    lateinit var photos : List<Photo>

    fun getAlbums() : List<Int>{
        return photos.map {photo ->
            photo.albumId
        }.filterNotNull()

    }
}