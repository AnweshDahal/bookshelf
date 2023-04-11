package com.example.bookshelf.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookshelf.views.DetailScreen
import com.example.bookshelf.views.MainScreen

// This is the root navigation controller for the app
@Composable
fun RootNavigatorGraph() {
    val navController = rememberNavController() // main navigation controller
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}", // you can add multiple routes like this /{name}/{age},
        arguments = listOf(
            navArgument("name"){
                type = NavType.StringType
                defaultValue = "User"
                nullable = true
            }
        )
        ){
            entry -> DetailScreen(name = entry.arguments?.getString("name"))
        }
    }
}