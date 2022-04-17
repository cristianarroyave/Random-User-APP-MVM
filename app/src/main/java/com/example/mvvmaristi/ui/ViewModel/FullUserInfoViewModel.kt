package com.example.mvvmaristi.ui.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmaristi.data.model.fullUserInfo.FullUserInfo
import com.example.mvvmaristi.domain.FullUserInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FullUserInfoViewModel @Inject constructor(
    private val fullUserInfoUseCase: FullUserInfoUseCase
): ViewModel() {
    val fullInfo = MutableLiveData<FullUserInfo>()

    fun onCreate(name: String){
        viewModelScope.launch {
            val result = fullUserInfoUseCase(name)
            fullInfo.postValue(FullUserInfo(result!!.name, result!!.image, result!!.email, result!!.street, result!!.city, result!!.country, result!!.age))
        }

    }
}