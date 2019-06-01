package com.acm.workshop.feedme.app.di.module

import com.acm.workshop.feedme.data.datasource.PostRemoteDataSource
import com.acm.workshop.feedme.data.repository.PostsRepositoryImpl
import com.acm.workshop.feedme.domain.repository.PostsRepository
import com.acm.workshop.feedme.remote.api.PostApi
import com.acm.workshop.feedme.remote.datasource.PostRemoteDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class PostsModule {

    @Provides
    fun providePostRemoteDataSource(postApi: PostApi) : PostRemoteDataSource{
        return PostRemoteDataSourceImpl(postApi)
    }


    @Provides
    fun providePostsRepository(dataSource: PostRemoteDataSource) : PostsRepository{
        return PostsRepositoryImpl(dataSource)
    }
}