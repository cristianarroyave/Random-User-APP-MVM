package com.example.mvvmaristi.ui.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmaristi.data.model.UserModel
import com.example.mvvmaristi.data.model.UserProvider
import com.example.mvvmaristi.domain.RandomUsersUseCase
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    val userModel = MutableLiveData<List<UserModel>>()
    var getRandomUsersUseCase = RandomUsersUseCase()

    init {
        onCreate()
    }

    /*fun randomUsers(): List<UserModel>{
        val currentUsers = UserProvider.randomUsers
        userModel.postValue(currentUsers)
        return currentUsers
    }*/

    fun onCreate() {
        viewModelScope.launch {
            val result = getRandomUsersUseCase()

            if(!result.isNullOrEmpty()){
                userModel.postValue(result)
            }

        }
    }
}