package com.example.mvvmaristi.domain.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mvvmaristi.ui.view.Screens.ListsUsers
import com.example.mvvmaristi.ui.ViewModel.UserViewModel
import com.example.mvvmaristi.ui.view.Screens.UserDetailScreen

@Composable
fun AppNavigation(userViewModel: UserViewModel){
    val navController = rememberNavController()
    val userListState by userViewModel.userModel.observeAsState()
    NavHost(navController = navController, startDestination = AppScreens.ListsScreen.route){
        composable(route = AppScreens.ListsScreen.route){
            userListState?.let { ListsUsers(userList = it, userViewModel, navController = navController) }
        }
        composable( route = AppScreens.DetailScreen.route + "/{name}",
                    arguments = listOf(navArgument(name = "name"){
                        type = NavType.StringType
                    })){
            UserDetailScreen(navController = navController, name = it.arguments?.getString("name"))
        }
    }
}