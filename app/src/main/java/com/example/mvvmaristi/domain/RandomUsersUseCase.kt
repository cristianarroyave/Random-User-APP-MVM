package com.example.mvvmaristi.domain

import com.example.mvvmaristi.data.RandomUserRepository
import com.example.mvvmaristi.data.model.UserModel
import javax.inject.Inject

class RandomUsersUseCase @Inject constructor(
    private val repository : RandomUserRepository
) {

    suspend operator fun invoke(): List<UserModel>? = repository.getRandomUsers()

}