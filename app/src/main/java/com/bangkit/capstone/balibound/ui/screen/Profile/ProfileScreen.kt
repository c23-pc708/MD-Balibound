package com.bangkit.capstone.balibound.ui.screen.Profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bangkit.capstone.balibound.R
import com.bangkit.capstone.balibound.ui.component.BottomNavigationBar
import com.bangkit.capstone.balibound.ui.component.CustomButton
import com.bangkit.capstone.balibound.ui.theme.Blue500
import com.bangkit.capstone.balibound.ui.theme.FontFamily

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    navController: NavController = rememberNavController()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color("#FDFDFF".toColorInt()),
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                },
                backgroundColor = Blue500,
                modifier = Modifier.size(60.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_bookmark),
                    contentDescription = "Check",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.header_background),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp),
                            contentDescription = "Profile Background"
                        )

                        Image(
                            painter = painterResource(id = R.drawable.avatar),
                            modifier = Modifier
                                .padding(top = 50.dp)
                                .align(Alignment.TopCenter)
                                .size(100.dp),
                            contentDescription = "Profile Picture"
                        )

                        Text(
                            text = "Raditya Firman Syaputra",
                            fontFamily = FontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Normal,
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(top = 160.dp),
                        )

                        Text(
                            text = "radit@student.uns.ac.id",
                            fontFamily = FontFamily,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(top = 190.dp),
                        )
                    }
                }
            }
            item {
                Card(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color("#F0F1F3".toColorInt()),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 24.dp),
                    elevation = 0.dp,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            "Profile",
                            fontFamily = FontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Normal,
                            fontSize = 16.sp,
                            color = Blue500
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = "Name",
                                fontFamily = FontFamily,
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Normal,
                                fontSize = 14.sp,
                                color = Color("#9DA3B0".toColorInt())
                            )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(text = "Raditya Firman Syaputra",
                            fontFamily = FontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Normal,
                            fontSize = 14.sp,
                            color = Color("#292D35".toColorInt())
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Divider(
                            color = Color("#F0F1F3".toColorInt()),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Email",
                            fontFamily = FontFamily,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            fontSize = 14.sp,
                            color = Color("#9DA3B0".toColorInt())
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(text = "radit@student.uns.ac.id",
                            fontFamily = FontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Normal,
                            fontSize = 14.sp,
                            color = Color("#292D35".toColorInt())
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Divider(
                            color = Color("#F0F1F3".toColorInt()),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Phone Number",
                            fontFamily = FontFamily,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            fontSize = 14.sp,
                            color = Color("#9DA3B0".toColorInt())
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(text = "+6281234567890",
                            fontFamily = FontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Normal,
                            fontSize = 14.sp,
                            color = Color("#292D35".toColorInt())
                        )

                    }
                }
            }

            item{
                Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
                    Spacer(modifier = Modifier.height(20.dp))
                    CustomButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.fillMaxWidth().height(44.dp).border(
                            width = 1.dp,
                            color = Color("#F5A4A4".toColorInt()),
                            shape = RoundedCornerShape(88.dp)
                        ),
                        backgroundColor = Color("#FDFDFF".toColorInt()),
                        contentColor = Color("#E54240".toColorInt()),
                        text = "Logout",

                    )
                }
            }
        }
    }
}
