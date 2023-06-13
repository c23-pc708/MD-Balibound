package com.bangkit.capstone.balibound.ui.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object HomeScreen : Screen("home_screen")
    object ProfileScreen : Screen("profile_screen")
    object DestinationScreen : Screen("destination_screen")

}