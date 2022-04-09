package com.example.mvvmaristi.data.model

import javax.inject.Inject

class UserProvider @Inject constructor(){
    var randomUsers:List<UserModel> = emptyList()
}