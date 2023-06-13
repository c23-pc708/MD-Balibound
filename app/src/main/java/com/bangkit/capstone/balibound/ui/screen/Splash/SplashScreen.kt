package com.bangkit.capstone.balibound.ui.screen.Splash

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bangkit.capstone.balibound.R
import com.bangkit.capstone.balibound.ui.component.CustomButton
import com.bangkit.capstone.balibound.ui.navigation.Screen
import com.bangkit.capstone.balibound.ui.theme.Blue500
import com.bangkit.capstone.balibound.ui.theme.FontFamily

@Composable
fun SplashScreen(
    navController: NavController? = rememberNavController(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 0.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash),
            contentScale = ContentScale.FillBounds,
            contentDescription = "animation",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .background(color = Blue500)
                .padding(all = 0.dp)
        )

        Spacer(modifier = Modifier.height(38.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color("#292D35".toColorInt()),
                    )
                ) {
                    append("Your Gateway to Extraordinary")
                }
                withStyle(
                    style = SpanStyle(
                        color = Blue500,
                    )
                ) {
                    append("\nJourneys")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color("#292D35".toColorInt()),
                    )
                ) {
                    append(".")
                }
            },
            fontFamily = FontFamily,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
            lineHeight = 38.sp,
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Unleash the full potential of your Bali vacation with Balibound! This ingenious app generates personalized travel recommendations, making sure you explore Bali in a way that perfectly aligns with your preferences.",
            fontFamily = FontFamily,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            color = Color("#858D9D".toColorInt()),
            fontSize = 12.sp,
            lineHeight = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        CustomButton(
            onClick = {
                navController?.navigate(Screen.LoginScreen.route){
                    popUpTo(Screen.SplashScreen.route){
                        inclusive = true
                    }
                }
            },
            text = "Explore Now",
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .padding(horizontal = 20.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}