package com.example.mvvmaristi.data

import com.example.mvvmaristi.data.firebase.Firebase
import com.example.mvvmaristi.data.model.UserProvider
import com.example.mvvmaristi.data.model.fullUserInfo.FullUserInfo
import javax.inject.Inject

class FullUserInfoRepository @Inject constructor(
    private val db:Firebase,
    private val userProvider: UserProvider
) {
    suspend fun getUserInfo(name: String): FullUserInfo? {
        val response = db.getUserData(name)
        userProvider.fullUserInfo = response
        return response
    }
}