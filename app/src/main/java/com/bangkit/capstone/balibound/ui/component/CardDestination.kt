package com.bangkit.capstone.balibound.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
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
import coil.compose.AsyncImage
import com.bangkit.capstone.balibound.R
import com.bangkit.capstone.balibound.data.model.response.DestinationItemResponse
import com.bangkit.capstone.balibound.ui.theme.Blue500
import com.bangkit.capstone.balibound.ui.theme.FontFamily

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardDestination(
    DestinationItemResponse: DestinationItemResponse,
    onClick: (Int) -> Unit = {},
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color("#F0F1F3".toColorInt()),
                shape = RoundedCornerShape(16.dp)
            ),
        elevation = 0.dp,
        onClick = {
            onClick(DestinationItemResponse.id)
        },
        backgroundColor = Color.White, shape = RoundedCornerShape(16.dp),
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {

            AsyncImage(
                model = DestinationItemResponse.imageLink,
                contentDescription = DestinationItemResponse.name,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
            )

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = DestinationItemResponse.name,
                maxLines = 1,
                fontFamily = FontFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color("#000000".toColorInt())
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = DestinationItemResponse.location,
                maxLines = 1,
                fontFamily = FontFamily,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color("#858D9D".toColorInt())
            )
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_access_time_24),
                        contentDescription = "Icon",
                        modifier = Modifier.size(16.dp),
                        tint = Blue500
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = DestinationItemResponse.weekdaysTime,
                        fontFamily = FontFamily,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        color = Blue500,
                        modifier = Modifier.padding(top = 3.dp)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_24),
                        contentDescription = "Icon",
                        modifier = Modifier.size(16.dp),
                        tint = Color("#F5CB00".toColorInt())
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = DestinationItemResponse.rating.toString(),
                        fontFamily = FontFamily,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color("#F5CB00".toColorInt()),
                        modifier = Modifier.padding(top = 3.dp)
                    )
                }


            }
        }
    }
}


