package com.acm.workshop.feedme.app.di.module

import com.acm.workshop.feedme.data.datasource.AlbumsRemoteDataSource
import com.acm.workshop.feedme.data.repository.AlbumsRepositoryImpl
import com.acm.workshop.feedme.domain.repository.AlbumsRepository
import com.acm.workshop.feedme.remote.api.AlbumsApi
import com.acm.workshop.feedme.remote.datasource.AlbumsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class AlbumsModule {

    @Provides
    fun provideAlbumRemoteDataSource(albumsApi: AlbumsApi) : AlbumsRemoteDataSource{
        return AlbumsRemoteDataSourceImpl(albumsApi)
    }


    @Provides
    fun provideAlbumRepository(albumsRemoteDataSource: AlbumsRemoteDataSource) : AlbumsRepository{
        return AlbumsRepositoryImpl(albumsRemoteDataSource)
    }
}