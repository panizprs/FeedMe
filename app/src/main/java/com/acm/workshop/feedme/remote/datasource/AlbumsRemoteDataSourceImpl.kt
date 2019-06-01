package com.acm.workshop.feedme.remote.datasource

import com.acm.workshop.feedme.data.datasource.AlbumsRemoteDataSource
import com.acm.workshop.feedme.data.model.Album
import com.acm.workshop.feedme.remote.api.AlbumsApi
import io.reactivex.Single

class AlbumsRemoteDataSourceImpl(private val albumsApi: AlbumsApi) : AlbumsRemoteDataSource {
    override fun getAlbums(): Single<List<Album>> {
        return albumsApi.getAlbums()
    }

}