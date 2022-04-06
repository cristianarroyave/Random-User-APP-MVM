package com.example.mvvmaristi.domain

import com.example.mvvmaristi.data.RandomUserRepository
import com.example.mvvmaristi.data.model.UserModel

class RandomUsersUseCase {

    private val repository = RandomUserRepository()

    suspend operator fun invoke(): List<UserModel>? = repository.getRandomUsers()

}