package com.bangkit.capstone.balibound.ui.screen.Login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.bangkit.capstone.balibound.ui.component.CustomButton
import com.bangkit.capstone.balibound.ui.component.TextInput
import com.bangkit.capstone.balibound.ui.navigation.Screen
import com.bangkit.capstone.balibound.ui.theme.Blue500
import com.bangkit.capstone.balibound.ui.theme.FontFamily

@Composable
fun LoginScreen(
    navController: NavController? = null
) {

    val (email, setEmail) = remember {
        mutableStateOf("")
    }

    val (password, setPassword) = remember {
        mutableStateOf("")
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
            value = email,
            onValueChange = setEmail,
            label = "Email Address",
            placeholder = "mail@example.com",
            type = "email"
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextInput(
            value = password,
            onValueChange = setPassword,
            label = "Password",
            placeholder = "********",
            type = "password"
        )

        Spacer(modifier = Modifier.height(40.dp))

        CustomButton(
            onClick = {
                navController?.navigate(Screen.HomeScreen.route){
                    popUpTo(Screen.LoginScreen.route){
                        inclusive = true
                    }
                }
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
                        navController?.navigate(Screen.RegisterScreen.route){
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