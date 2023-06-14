package com.bangkit.capstone.balibound.ui.screen.Login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bangkit.capstone.balibound.ui.component.CustomButton
import com.bangkit.capstone.balibound.ui.component.TextInput
import com.bangkit.capstone.balibound.ui.navigation.Screen
import com.bangkit.capstone.balibound.ui.theme.Blue500
import com.bangkit.capstone.balibound.ui.theme.FontFamily
import com.bangkit.capstone.balibound.utils.Result

@Composable
fun LoginScreen(
    navController: NavController = rememberNavController(),
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val loading = loginViewModel.loading.collectAsState().value
    val loadingState = loginViewModel.loginState.collectAsState().value

    val (username, setUsername) = remember {
        mutableStateOf("")
    }
    val (password, setPassword) = remember {
        mutableStateOf("")
    }
    val (isUsernameValid, setIsUsernameValid) = remember {
        mutableStateOf(false)
    }
    val (isPasswordValid, setIsPasswordValid) = remember {
        mutableStateOf(false)
    }

    when(loadingState){
        is Result.Error -> {
            Toast.makeText(navController.context, "Email / Password yang anda masukan salah", Toast.LENGTH_SHORT).show()
        }
        is Result.Success -> {
            if (navController.currentDestination?.route == Screen.LoginScreen.route) {
                navController.navigate(Screen.HomeScreen.route){
                    popUpTo(Screen.LoginScreen.route){
                        inclusive = true
                    }
                }
            }
        }
        else -> {
            Log.d("LoginScreen", "Login Response : $loadingState")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(
            modifier = Modifier.height(52.dp)
        )

        Text(
            text = "Sign In",
            fontSize = 20.sp,
            fontFamily = FontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            color = Blue500
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Continue your journey by signing in to the application.",
            fontSize = 14.sp,
            fontFamily = FontFamily,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            color = Color("#858D9D".toColorInt())
        )

        Spacer(modifier = Modifier.height(40.dp))

        TextInput(
            value = username,
            onValueChange = setUsername,
            label = "Username",
            placeholder = "Username",
            type = "text",
            isValid = {
                setIsUsernameValid(it)
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextInput(
            value = password,
            onValueChange = setPassword,
            label = "Password",
            placeholder = "********",
            type = "password",
            isValid = {
                setIsPasswordValid(it)
            }
        )

        Spacer(modifier = Modifier.height(40.dp))

        CustomButton(
            onClick = {
                if(loading){
                    Toast.makeText(navController.context, "Mohon tunggu sebentar", Toast.LENGTH_SHORT).show()
                    return@CustomButton
                }

                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(navController.context, "Username dan password tidak boleh kosong", Toast.LENGTH_SHORT).show()
                    return@CustomButton
                }

                if(!isUsernameValid || !isPasswordValid){
                    Toast.makeText(navController.context, "Username dan password tidak valid", Toast.LENGTH_SHORT).show()
                    return@CustomButton
                }

                loginViewModel.login(username, password)
            },
            text = "Login",
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))


        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Don't have an account? ",
                fontSize = 14.sp,
                fontFamily = FontFamily,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                color = Color("#667085".toColorInt())
            )

            Text(
                text = "Register",
                fontSize = 14.sp,
                fontFamily = FontFamily,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.RegisterScreen.route){
                            popUpTo(Screen.LoginScreen.route){
                                inclusive = true
                            }
                        }
                    },
                color = Blue500
            )
        }
    }
}