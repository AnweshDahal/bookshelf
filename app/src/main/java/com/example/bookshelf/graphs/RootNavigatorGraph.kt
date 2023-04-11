package com.example.bookshelf.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// This is the root navigation controller for the app
@Composable
fun RootNavigatorGraph() {
    val navController = rememberNavController() // main navigation controller
    NavHost(navController = navController, startDestination = Screen.MainScreenRouter.route) {
        composable(route = Screen.MainScreenRouter.route){
            TODO("The activity you want to display")
        }
    }
}