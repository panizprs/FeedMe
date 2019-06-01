package com.acm.workshop.feedme.data.repository

import com.acm.workshop.feedme.data.datasource.AlbumsRemoteDataSource
import com.acm.workshop.feedme.data.model.Album
import com.acm.workshop.feedme.domain.repository.AlbumsRepository
import io.reactivex.Single

class AlbumsRepositoryImpl(private val albumsRemoteDataSource: AlbumsRemoteDataSource) : AlbumsRepository{
    override fun getAlbums(): Single<List<Album>> {
        return albumsRemoteDataSource.getAlbums()
    }


}