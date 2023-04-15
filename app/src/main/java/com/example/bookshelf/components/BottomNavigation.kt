package com.example.bookshelf.components


import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bookshelf.R
import com.example.bookshelf.config.BottomNavBarItemType
import com.example.bookshelf.models.BottomNavItem

@Composable
fun BottomNavigation(navController: NavController) {
    // state
    var selectedItem by remember {
        mutableStateOf(0)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination
    // data
    val bottomNavItems = listOf(
        BottomNavItem(
            type = BottomNavBarItemType.LINK,
            label = "Home",
            route = "home",
            icon = painterResource(id = R.drawable.home)
        ),
        BottomNavItem(
            type = BottomNavBarItemType.LINK,
            label = "Explore",
            route = "explore",
            icon = painterResource(id = R.drawable.explore)
        ),
        BottomNavItem(
            type = BottomNavBarItemType.LINK,
            label = "Library",
            route = "library",
            icon = painterResource(id = R.drawable.menu_book)
        )
    )

    NavigationBar(modifier = Modifier.height(80.dp)) {
        bottomNavItems.forEachIndexed { index, item ->
            NavigationBarItem(
                // hierarchy provides a stack of navigation history
                // the stack starts with the current location and
                // is followed by the preceding until the root of
                // navigation
                // Here we are using any, which returns true if at least one of the
                // conditions are true, since hierarchy will have the current route
                selected = currentRoute?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route){
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // re-selecting the same item
                        launchSingleTop = true
                        // restore the state when reselecting a previously selected item
                        restoreState = true;
                    }


                },
                icon = {
                    Icon(
                        painter = item.icon, contentDescription = null, modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                    )
                })
        }
    }
}