package com.example.mvvmaristi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mvvmaristi.ui.view.Screens.ListsUsers
import com.example.mvvmaristi.ui.view.Screens.UserDetailScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.ListsScreen.route){
        composable(route = AppScreens.ListsScreen.route){
            ListsUsers(navController = navController)
        }
        composable( route = AppScreens.DetailScreen.route + "/{name}",
                    arguments = listOf(navArgument(name = "name"){
                        type = NavType.StringType
                    })){
            UserDetailScreen(navController = navController, name = it.arguments?.getString("name"))
        }
    }
}