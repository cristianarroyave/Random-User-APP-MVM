package com.example.mvvmaristi.data.network

import com.example.mvvmaristi.core.RetrofitHelper
import com.example.mvvmaristi.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class RandomUserService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getRandomUsers():List<UserModel>{
        return withContext(Dispatchers.IO){
            val userList: ArrayList<UserModel> = ArrayList()
            val response = retrofit.create(RandomUsersApiClient::class.java).getRandomUsers()

            if(response.isSuccessful){
                response.body()?.results?.forEach { user ->
                    userList.add(UserModel(user.name.first + " " + user.name.last, user.email, user.picture.large))
                }
            }

            userList.toList()
        }
    }
}