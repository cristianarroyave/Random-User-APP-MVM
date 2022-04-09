package com.example.mvvmaristi.data

import com.example.mvvmaristi.data.model.UserModel
import com.example.mvvmaristi.data.model.UserProvider
import com.example.mvvmaristi.data.network.RandomUserService
import com.example.mvvmaristi.ui.ViewModel.UserViewModel
import javax.inject.Inject

class RandomUserRepository @Inject constructor(
    private val api : RandomUserService,
    private val userProvider: UserProvider
) {
    suspend fun getRandomUsers():List<UserModel>{
        val response = api.getRandomUsers()
        userProvider.randomUsers = response
        return response
    }
}