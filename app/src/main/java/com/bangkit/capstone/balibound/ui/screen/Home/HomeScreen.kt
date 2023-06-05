package com.bangkit.capstone.balibound.ui.screen.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.bangkit.capstone.balibound.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.bangkit.capstone.balibound.ui.component.*
import com.bangkit.capstone.balibound.ui.navigation.Screen
import com.bangkit.capstone.balibound.ui.theme.Blue500
import com.bangkit.capstone.balibound.ui.theme.Blue700
import com.bangkit.capstone.balibound.ui.theme.FontFamily
import com.bangkit.capstone.balibound.utils.ext.gridItems


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    navController: NavController = rememberNavController()
) {

    val (search, setSearch) = remember {
        mutableStateOf("")
    }

    val listDestination = List<Destination>(
        5
    ) {
        Destination(
            id = 0,
            image = "",
            title = "Pura Tanah Lot",
            location = "Tabanan",
            time = "08.00 - 17.00",
        )
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color("#FDFDFF".toColorInt()),
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.SavedScreen.route)
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
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color("#FDFDFF".toColorInt()))
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
                            contentDescription = "Header Background",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.TopStart)
                                .padding(top = 55.dp, start = 20.dp, end = 20.dp),
                        ) {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                                    Row() {
                                        Image(painter = painterResource(id = R.drawable.avatar), contentDescription = "Avatar", modifier = Modifier.size(48.dp))
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Column() {
                                            Text(text = "Raditya Firman S", fontFamily = FontFamily, fontSize = 18.sp, color = Color("#F0F1F3".toColorInt()), fontWeight = FontWeight.SemiBold)
                                            Text(text = "radit@student.uns.ac.id", fontFamily = FontFamily, fontSize = 12.sp, color = Color("#E0E2E7".toColorInt()))
                                        }
                                    }
                                    Row() {
                                        Icon(painterResource(id = R.drawable.icon_bookmark), contentDescription = "Bookmark", tint = Color("#F0F1F3".toColorInt()), modifier = Modifier.size(36.dp))
                                    }
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                TextInput(value = search, onValueChange = setSearch, placeholder = "Search destination", modifier = Modifier.fillMaxWidth(), leadingIcon = {
                                    Icon(imageVector = Icons.Filled.Search, contentDescription = null, tint = Color("#BDBDBD".toColorInt()), modifier = Modifier.size(24.dp))
                                },
                                shape = RoundedCornerShape(8.dp)
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                LazyRow{
                                    items(5, itemContent = {
                                        CardCategory(

                                        )
                                        Spacer(modifier = Modifier.width(7.dp))
                                    })
                                }
                            }

                        }
                    }
                }
            }

            gridItems(
                data = listDestination,
                columnCount = 2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                itemContent = { item ->
                    CardDestination(
                        destination = item,
                        onClick = {
                            navController.navigate(Screen.DestinationScreen.route + "/${item.id}")
                        }
                    )
                })

            item{
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@ExperimentalFoundationApi
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

