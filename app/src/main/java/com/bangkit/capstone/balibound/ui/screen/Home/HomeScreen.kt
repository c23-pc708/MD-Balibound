package com.bangkit.capstone.balibound.ui.screen.Home

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.runtime.*
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
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
    navController: NavController = rememberNavController(),
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    var loading = homeViewModel.loading.collectAsState().value
    var userData = homeViewModel.userData.collectAsState().value
    var destinations = homeViewModel.destinations.collectAsState().value

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.card_skleton))
    val items = (0..3).toList()

    val (search, setSearch) = remember {
        mutableStateOf("")
    }

    val (category, setCategory) = remember {
        mutableStateOf(
            itemsCardCategoryData
        )
    }
    
    search.useDebounce(1000) {
        homeViewModel.searchDestinations(it, category)
    }

    fun changeCategoryState(id: Int, state: Boolean) {
        val newCategory = category.mapIndexed { index, cardCategoryData ->
            if (index == id) cardCategoryData.copy(
                isActive = !state
            ) else cardCategoryData
        }

        homeViewModel.searchDestinations(search, category)
        setCategory(newCategory)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color("#FDFDFF".toColorInt()),
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
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
                                .padding(top = 48.dp, start = 20.dp, end = 20.dp),
                        ) {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row() {
                                        Image(
                                            painter = painterResource(id = R.drawable.avatar),
                                            contentDescription = "Avatar",
                                            modifier = Modifier.size(48.dp)
                                        )
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Column() {
                                            Text(
                                                text = "Hello, ${userData?.firstName ?: "User"}",
                                                fontFamily = FontFamily,
                                                fontSize = 18.sp,
                                                color = Color("#F0F1F3".toColorInt()),
                                                fontWeight = FontWeight.SemiBold
                                            )
                                            Text(
                                                text = userData?.email ?: "user@mail.com",
                                                fontFamily = FontFamily,
                                                fontSize = 12.sp,
                                                color = Color("#E0E2E7".toColorInt())
                                            )
                                        }
                                    }
                                    Row() {

                                    }
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                TextInput(
                                    value = search,
                                    onValueChange = setSearch,
                                    placeholder = "Search destination",
                                    modifier = Modifier.fillMaxWidth(),
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Filled.Search,
                                            contentDescription = null,
                                            tint = Color("#BDBDBD".toColorInt()),
                                            modifier = Modifier.size(24.dp)
                                        )
                                    },
                                    shape = RoundedCornerShape(8.dp)
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                LazyRow {
                                    item {
                                        category.map {
                                            CardCategory(
                                                CardCategoryData = it,
                                                onClick = { id, state ->
                                                    changeCategoryState(id, state)
                                                }
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }


            if (loading) {
                gridItems(data = items, columnCount = 2, modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp), itemContent = {
                    LottieAnimation(
                        composition = composition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                })
            } else {
                gridItems(
                    data = destinations,
                    columnCount = 2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                    itemContent = { item ->
                        CardDestination(
                            item,
                            onClick = {
                                navController.navigate(Screen.DestinationScreen.route + "/${item.id}")
                            }
                        )
                    })
            }

            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}
