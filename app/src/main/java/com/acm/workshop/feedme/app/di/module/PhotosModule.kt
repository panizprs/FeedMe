package com.acm.workshop.feedme.app.di.module

import com.acm.workshop.feedme.data.datasource.PhotosRemoteDataSource
import com.acm.workshop.feedme.data.repository.PhotosRepositoryImpl
import com.acm.workshop.feedme.domain.repository.PhotosRepository
import com.acm.workshop.feedme.remote.api.PhotosApi
import com.acm.workshop.feedme.remote.datasource.PhotosRemoteDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class PhotosModule {

    @Provides
    fun providePhotosRemoteDataSource(photosApi: PhotosApi) : PhotosRemoteDataSource{
        return PhotosRemoteDataSourceImpl(photosApi)
    }


    @Provides
    fun providePhotosRepository(photosRemoteDataSource: PhotosRemoteDataSource) : PhotosRepository{
        return PhotosRepositoryImpl(photosRemoteDataSource)
    }
}