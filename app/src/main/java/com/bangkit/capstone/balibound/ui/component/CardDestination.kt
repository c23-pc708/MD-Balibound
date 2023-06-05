package com.bangkit.capstone.balibound.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Person
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
import com.bangkit.capstone.balibound.R
import com.bangkit.capstone.balibound.ui.theme.Blue500
import com.bangkit.capstone.balibound.ui.theme.FontFamily

data class Destination(
    val id : Int,
    val image : String,
    val title: String,
    val location : String,
    val time : String,
    val isSaved : Boolean = false,
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardDestination(
    destination: Destination = Destination(
        id = 0,
        image = "",
        title = "Pura Tanah Lot",
        location = "Tabanan",
        time = "08.00 - 17.00",
    ),
    onClick : (Int) -> Unit = {},
    isSavedScreen : Boolean = false,
) {
    Card(modifier = Modifier
        .fillMaxWidth().border(
            width = 1.dp,
            color = Color("#F0F1F3".toColorInt()),
            shape = RoundedCornerShape(16.dp)
        ), elevation = 0.dp, onClick = {
        onClick(destination.id)
    }, backgroundColor = Color.White, shape = RoundedCornerShape(16.dp),
    )
    {
        Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {
            Image(painter = painterResource(id = R.drawable.kuta), contentDescription = "Image", modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
            )

            Spacer(modifier = Modifier.height(12.dp))
            Text(text = destination.title, maxLines = 1, fontFamily = FontFamily, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color("#000000".toColorInt()))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = destination.location, maxLines = 1, fontFamily = FontFamily, fontSize = 10.sp, fontWeight = FontWeight.Normal, color = Color("#858D9D".toColorInt()))
            Spacer(modifier = Modifier.height(12.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.baseline_access_time_24), contentDescription = "Icon", modifier = Modifier.size(16.dp), tint = Blue500)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = destination.time, fontFamily = FontFamily, fontSize = 10.sp, fontWeight = FontWeight.Normal, color = Blue500)
                }

                if (isSavedScreen) {
                    Icon(painter = painterResource(id = R.drawable.baseline_delete_24), contentDescription = "Icon", modifier = Modifier.size(24    .dp), tint = Color.Red)
                } else {
                    Icon(
                        painter = if(destination.isSaved) painterResource(id = R.drawable.baseline_bookmark_24) else painterResource(id = R.drawable.baseline_bookmark_24),
                        contentDescription = "Icon",
                        tint = Blue500,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CardDestinationPreview() {
    CardDestination()
}