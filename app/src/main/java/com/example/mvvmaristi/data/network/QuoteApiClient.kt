package com.example.mvvmaristi.data.network

import com.example.mvvmaristi.data.model.UsersApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface RandomUsersApiClient {
    @GET("?results=10&inc=name,picture,email,registered,location&noinfo")
    suspend fun getRandomUsers(): Response<UsersApiResponse>
}