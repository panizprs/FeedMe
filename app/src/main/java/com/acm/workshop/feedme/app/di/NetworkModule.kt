package com.acm.workshop.feedme.app.di

import com.acm.workshop.feedme.remote.AlbumsApi
import com.acm.workshop.feedme.remote.PhotosApi
import com.acm.workshop.feedme.remote.PostApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .build()
    }


    @Provides
    @Singleton
    fun providePostApi(retrofit: Retrofit) = retrofit.create(PostApi::class.java)



    @Provides
    @Singleton
    fun providePhotoApi(retrofit: Retrofit) = retrofit.create(PhotosApi::class.java)


    @Provides
    @Singleton
    fun provideAlbumApi(retrofit: Retrofit) = retrofit.create(AlbumsApi::class.java)


    companion object {
        const val BASE_URL: String = "https://jsonplaceholder.typicode.com"
    }
}

fun main(){

    val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(NetworkModule.BASE_URL)
        .client(OkHttpClient())
        .build()

    val photosApi = retrofit.create(PhotosApi::class.java)



    photosApi.getPhotos().subscribe({photos ->
        photos.forEach {photo ->
            println(photo)
        }
    },{
        println("error $it")
    }
    )

}