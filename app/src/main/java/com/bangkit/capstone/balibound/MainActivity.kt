package com.bangkit.capstone.balibound

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bangkit.capstone.balibound.ui.navigation.Screen
import com.bangkit.capstone.balibound.ui.screen.Home.HomeScreen
import com.bangkit.capstone.balibound.ui.screen.Login.LoginScreen
import com.bangkit.capstone.balibound.ui.screen.Profile.ProfileScreen
import com.bangkit.capstone.balibound.ui.screen.Register.RegisterScreen
import com.bangkit.capstone.balibound.ui.screen.Splash.SplashScreen
import com.bangkit.capstone.balibound.ui.theme.BaliBoundTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaliBoundTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 0.dp)
                ) {
                    NavHost(
                        navController = navController, startDestination = Screen.SplashScreen.route
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
                    }
                }
            }
        }
    }
}