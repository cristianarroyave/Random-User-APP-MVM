package com.example.mvvmaristi.ui.navigation

sealed class AppScreens(val route: String){
    object ListsScreen: AppScreens("listScreen")
    object DetailScreen: AppScreens("detailScreen")

}
