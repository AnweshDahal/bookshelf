package com.example.bookshelf.graphs

// a sealed class is a type of class that allows inheritance only to the classes inside of it
sealed class Screen(val route: String){
    /*
    * Objects are used to setup route names
    * this allows us to perform additional actions on the route name instead of being left
    * with just the string containing the name of the route.
    * object is a special type of class that does not require any parameter
     */
    object MainScreen : Screen("main_screen")
}
