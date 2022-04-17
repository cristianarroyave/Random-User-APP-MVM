package com.example.mvvmaristi.data.network

import com.example.mvvmaristi.data.firebase.Firebase
import com.example.mvvmaristi.data.model.UserModel
import com.example.mvvmaristi.data.model.fullUserInfo.FullUserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RandomUserService @Inject constructor(
    private val api:RandomUsersApiClient,
    private val db:Firebase
){

    suspend fun getRandomUsers():List<UserModel>{
        return withContext(Dispatchers.IO){
            val userList: ArrayList<UserModel> = ArrayList()
            val response = api.getRandomUsers()

            if(response.isSuccessful){
                response.body()?.results?.forEach { user ->
                    userList.add(UserModel(user.name.first + " " + user.name.last, user.email, user.picture.large))
                    db.insertData(FullUserInfo(user.name.first + " " + user.name.last, user.picture.large, user.email, user.location.street.name + " " + user.location.street.number.toString(), user.location.city, user.location.country, user.registered.age))
                }
            }
            userList.toList()
        }
    }
}