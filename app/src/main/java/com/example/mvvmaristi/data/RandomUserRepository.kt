package com.example.mvvmaristi.data

import com.example.mvvmaristi.data.model.UserModel
import com.example.mvvmaristi.data.model.UserProvider
import com.example.mvvmaristi.data.network.RandomUserService
import com.example.mvvmaristi.ui.ViewModel.UserViewModel

class RandomUserRepository {

    private val api = RandomUserService()

    suspend fun getRandomUsers():List<UserModel>{
        val response = api.getRandomUsers()
        UserProvider.randomUsers = response
        return response
    }
}