package com.bangkit.capstone.balibound

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bangkit.capstone.balibound.ui.navigation.Screen
import com.bangkit.capstone.balibound.ui.screen.Destination.DestinationScreen
import com.bangkit.capstone.balibound.ui.screen.Home.HomeScreen
import com.bangkit.capstone.balibound.ui.screen.Login.LoginScreen
import com.bangkit.capstone.balibound.ui.screen.Profile.ProfileScreen
import com.bangkit.capstone.balibound.ui.screen.Register.RegisterScreen
import com.bangkit.capstone.balibound.ui.screen.Splash.SplashScreen
import com.bangkit.capstone.balibound.ui.screen.Splash.SplashViewModel
import com.bangkit.capstone.balibound.ui.theme.BaliBoundTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaliBoundTheme {

                val authViewModel = hiltViewModel<SplashViewModel>(this)
                val isLogged = authViewModel.isLogged.collectAsState().value

                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 0.dp)
                ) {
                    NavHost(
                        navController = navController, startDestination = if (isLogged) {
                            Screen.HomeScreen.route
                        } else {
                            Screen.SplashScreen.route
                        }
                    ) {
                        composable(Screen.SplashScreen.route) {
                            SplashScreen(navController = navController)
                        }
                        composable(Screen.LoginScreen.route) {
                            LoginScreen(navController = navController)
                        }
                        composable(Screen.RegisterScreen.route) {
                            RegisterScreen(navController = navController)
                        }
                        composable(Screen.HomeScreen.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(Screen.ProfileScreen.route) {
                            ProfileScreen(navController = navController)
                        }
                        composable(Screen.DestinationScreen.route + "/{destinationId}") {
                            DestinationScreen(
                                navController = navController,
                                destinationId = it.arguments?.getString("destinationId")
                            )
                        }
                    }
                }
            }
        }
    }
}