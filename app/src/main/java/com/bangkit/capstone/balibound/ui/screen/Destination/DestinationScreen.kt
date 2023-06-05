package com.bangkit.capstone.balibound.ui.screen.Destination


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bangkit.capstone.balibound.R
import com.bangkit.capstone.balibound.ui.component.CustomButton
import com.bangkit.capstone.balibound.ui.theme.Blue500
import com.bangkit.capstone.balibound.ui.theme.FontFamily

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DestinationScreen(
    navController: NavController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            CustomButton(onClick = { /*TODO*/ }, text = "Get Direction", modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp))
        }
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.kuta_full),
                        contentDescription = "kuta",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 50.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                        ) {
                            Button(
                                onClick = {
                                    navController.popBackStack()
                                },
                                border = null,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .border(
                                        width = 1.dp,
                                        color = Color.Gray.copy(
                                            alpha = 0.2f
                                        ),
                                        shape = CircleShape
                                    ),
                                shape = CircleShape,
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Gray.copy(
                                        alpha = 0.2f
                                    ),
                                )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.arrow_back_24px),
                                    contentDescription = "back",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }

                        Row {
                            Button(
                                onClick = { /*TODO*/ },
                                border = null,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .border(
                                        width = 1.dp,
                                        color = Color.Gray.copy(
                                            alpha = 0.2f
                                        ),
                                        shape = CircleShape
                                    ),
                                shape = CircleShape,
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Gray.copy(
                                        alpha = 0.2f
                                    ),
                                ),
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxHeight()) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_star_24),
                                        contentDescription = "star",
                                        modifier = Modifier.size(20.dp),
                                        tint = Color("#F5CB00".toColorInt())
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(text = "4.5", fontSize = 16.sp, fontFamily = FontFamily, color = Color.White, modifier = Modifier.padding(top=4.dp))
                                }
                            }

                            Spacer(modifier = Modifier.width(8.dp))
                            Button(
                                onClick = { /*TODO*/ },
                                border = null,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .border(
                                        width = 1.dp,
                                        color = Color.Gray.copy(
                                            alpha = 0.2f
                                        ),
                                        shape = CircleShape
                                    ),
                                shape = CircleShape,
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Gray.copy(
                                        alpha = 0.2f
                                    ),
                                )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.icon_bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .padding(top = 320.dp)
                            .fillMaxWidth()
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                            )
                    ) {

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(20.dp))
                            Divider(
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(4.dp),
                                color = Color("#E0E2E7".toColorInt()),
                            )
                            Spacer(modifier = Modifier.height(30.dp))
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                        ) {
                            Text(
                                text = "Pantai Kuta",
                                color = Blue500,
                                fontFamily = FontFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 20.sp
                            )

                            Spacer(modifier = Modifier.height(14.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(painter = painterResource(id = R.drawable.baseline_location_on_24), contentDescription = "Location", tint = Color("#858D9D".toColorInt()))
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(text = "Kuta", fontFamily = FontFamily, fontSize = 14.sp, color = Color("#858D9D".toColorInt()), modifier = Modifier.padding(top=2.dp))
                                }

                                Row() {
                                    Icon(painter = painterResource(id = R.drawable.baseline_access_time_24), contentDescription = "Time", tint = Color("#858D9D".toColorInt()))
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(text = "09:00 - 16:00", fontFamily = FontFamily, fontSize = 14.sp, color = Color("#858D9D".toColorInt()), modifier = Modifier.padding(top=2.dp))
                                }
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Divider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp),
                                color = Color("#E0E2E7".toColorInt()),
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = "Pantai Kuta adalah destinasi populer di Bali dengan pasir putih lembut dan ombak yang cocok untuk berselancar. Pantai ini juga terkenal dengan matahari terbenam yang indah dan memiliki suasana hidup dengan beragam kafe dan restoran.",
                                fontFamily = FontFamily,
                                fontWeight = FontWeight.Normal,
                                color = Color("#858D9D".toColorInt()),
                                fontSize = 14.sp
                            )

                        }
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DestinationScreenPreview() {
    DestinationScreen()
}