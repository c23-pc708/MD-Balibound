package com.bangkit.capstone.balibound.ui.screen.Profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bangkit.capstone.balibound.R
import com.bangkit.capstone.balibound.ui.component.BottomNavigationBar
import com.bangkit.capstone.balibound.ui.theme.Blue500

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
                    Image(
                        painterResource(id = R.drawable.header_background),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp),
                        contentDescription = "Profile Background"
                    )
                }
            }
        }
    }

}
