package com.example.mvvmaristi.ui.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmaristi.data.model.UserModel
import com.example.mvvmaristi.domain.RandomUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getRandomUsersUseCase:RandomUsersUseCase
): ViewModel() {

    val userModel = MutableLiveData<List<UserModel>>()

    init {
        onCreate()
    }

    fun onCreate() {
        viewModelScope.launch {
            val result = getRandomUsersUseCase()
            if(!result.isNullOrEmpty()){
                userModel.postValue(result)
            }
        }
    }
}