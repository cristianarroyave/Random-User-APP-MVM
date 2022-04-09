package com.example.mvvmaristi.di

import com.example.mvvmaristi.data.network.RandomUsersApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit
    {
        return Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRandomUserApiClient(retrofit: Retrofit):RandomUsersApiClient
    {
        return retrofit.create(RandomUsersApiClient::class.java)
    }

}