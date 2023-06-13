package com.bangkit.capstone.balibound.ui.screen.Register

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
fun RegisterScreen(
    navController: NavController = rememberNavController(),
    registerViewModel: RegisterViewModel = hiltViewModel()
) {
    val loading = registerViewModel.loading.collectAsState().value
    val registerState = registerViewModel.registerState.collectAsState().value

    val (username, setUsername) = remember {
        mutableStateOf("")
    }
    val (firstName, setFirstName) = remember {
        mutableStateOf("")
    }
    val (lastName, setLastName) = remember {
        mutableStateOf("")
    }
    val (email, setEmail) = remember {
        mutableStateOf("")
    }
    val (password, setPassword) = remember {
        mutableStateOf("")
    }
    val (phone, setPhone) = remember {
        mutableStateOf("")
    }

    val (isUsernameValid, setIsUsernameValid) = remember {
        mutableStateOf(false)
    }
    val (isFirstNameValid, setIsFirstNameValid) = remember {
        mutableStateOf(false)
    }
    val (isLastNameValid, setIsLastNameValid) = remember {
        mutableStateOf(false)
    }
    val (isEmailValid, setIsEmailValid) = remember {
        mutableStateOf(false)
    }
    val (isPasswordValid, setIsPasswordValid) = remember {
        mutableStateOf(false)
    }
    val (isPhoneValid, setIsPhoneValid) = remember {
        mutableStateOf(false)
    }

    when (registerState) {
        is Result.Error -> {
            Toast.makeText(
                navController.context,
                "Something went wrong, please try again later",
                Toast.LENGTH_SHORT
            ).show()
        }

        is Result.Success -> {
            if(navController.currentDestination?.route == Screen.RegisterScreen.route){
                navController.navigate(Screen.LoginScreen.route){
                    popUpTo(Screen.RegisterScreen.route){
                        inclusive = true
                    }
                }
            }
        }

        else -> {}

    }


    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)){
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(
                    modifier = Modifier.height(52.dp)
                )

                Text(
                    text = "Create an Account",
                    fontSize = 20.sp,
                    fontFamily = FontFamily,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    color = Blue500
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Register yourself and start exploring with us.",
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
                    value = firstName,
                    onValueChange = setFirstName,
                    label = "First Name",
                    placeholder = "John",
                    type = "text",
                    isValid = {
                        setIsFirstNameValid(it)
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))

                TextInput(
                    value = lastName,
                    onValueChange = setLastName,
                    label = "Last Name",
                    placeholder = "Doe",
                    type = "text",
                    isValid = {
                        setIsLastNameValid(it)
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))



                TextInput(
                    value = email,
                    onValueChange = setEmail,
                    label = "Email Address",
                    placeholder = "mail@example.com",
                    type = "email",
                    isValid = {
                        setIsEmailValid(it)
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))

                TextInput(
                    value = phone,
                    onValueChange = setPhone,
                    label = "Phone Number",
                    placeholder = "08xxxxxxxxxx",
                    type = "phone",
                    isValid = {
                        setIsPhoneValid(it)
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
                        if(loading) return@CustomButton

                        if(!isUsernameValid || !isFirstNameValid || !isLastNameValid || !isEmailValid || !isPhoneValid || !isPasswordValid){
                            Toast.makeText(
                                navController.context,
                                "Data is not valid",
                                Toast.LENGTH_SHORT
                            ).show()
                            return@CustomButton
                        }

                        registerViewModel.register(
                            username,
                            firstName,
                            lastName,
                            email,
                            phone,
                            password
                        )
                    },
                    text = "Register",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "Already have an account? ",
                        fontSize = 14.sp,
                        fontFamily = FontFamily,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = Color("#667085".toColorInt())
                    )

                    Text(
                        text = "Login",
                        fontSize = 14.sp,
                        fontFamily = FontFamily,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .clickable {
                                navController?.navigate(Screen.LoginScreen.route) {
                                    popUpTo(Screen.RegisterScreen.route) {
                                        inclusive = true
                                    }
                                }
                            },
                        color = Blue500
                    )
                }

                Spacer(modifier = Modifier.height(48.dp))
            }
        }
    }
}