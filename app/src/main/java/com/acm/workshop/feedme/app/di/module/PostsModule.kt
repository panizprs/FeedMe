package com.acm.workshop.feedme.app.di.module

import com.acm.workshop.feedme.data.datasource.PostsRemoteDataSource
import com.acm.workshop.feedme.data.repository.PostsRepositoryImpl
import com.acm.workshop.feedme.domain.repository.PostsRepository
import com.acm.workshop.feedme.remote.api.PostApi
import com.acm.workshop.feedme.remote.datasource.PostsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class PostsModule {

    @Provides
    fun providePostRemoteDataSource(postApi: PostApi) : PostsRemoteDataSource{
        return PostsRemoteDataSourceImpl(postApi)
    }


    @Provides
    fun providePostsRepository(dataSource: PostsRemoteDataSource) : PostsRepository{
        return PostsRepositoryImpl(dataSource)
    }
}