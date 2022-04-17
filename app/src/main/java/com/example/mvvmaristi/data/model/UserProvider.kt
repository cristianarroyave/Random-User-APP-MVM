package com.example.mvvmaristi.data.model

import com.example.mvvmaristi.data.model.fullUserInfo.FullUserInfo
import javax.inject.Inject

class UserProvider @Inject constructor(){
    var randomUsers:List<UserModel> = emptyList()
    var fullUserInfo: FullUserInfo? = null
}