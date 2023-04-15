package com.example.bookshelf.graphs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookshelf.views.ExploreScreen
import com.example.bookshelf.views.HomeScreen
import com.example.bookshelf.views.MainScreen

// This is the root navigation controller for the app
@Composable
fun RootNavigatorGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.MainScreenRouter.route) {
        composable(route = Screen.MainScreenRouter.route){
            // Use scaffolding here to display a consistent UI across
            // routes with similar ui , meaning if i want similar UI
            // in some pages refer to nested navigation for further info
            // https://github.com/stevdza-san/NestedNavigationBottomBarDemo
            MainScreen(navController = navController)
        }
        
        composable(route = Screen.HomeRouter.route){
            HomeScreen(navController = navController)
        }

        composable(route = Screen.ExploreRoute.route){
            ExploreScreen(navController = navController)
        }
        
        composable(route = Screen.LibraryRoute.route){
            Text(text = "This is Temp Library Page")
        }
    }
}