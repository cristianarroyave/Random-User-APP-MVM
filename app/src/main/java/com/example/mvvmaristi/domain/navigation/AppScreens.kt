package com.example.mvvmaristi.domain.navigation

sealed class AppScreens(val route: String){
    object ListsScreen: AppScreens("listScreen")
    object DetailScreen: AppScreens("detailScreen")

}
