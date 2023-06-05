package com.bangkit.capstone.balibound.ui.component

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.bangkit.capstone.balibound.ui.theme.FontFamily

data class CardCategoryData(
    val id : Int,
    val label : String,
    val value : String,
    val Icon : Int,
    val isActive : Boolean,
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardCategory(
    CardCategoryData: CardCategoryData = CardCategoryData(
        id = 0,
        label = "Art",
        value = "art",
        Icon = 0,
        isActive = true,
    ),
    onClick : (Int) -> Unit = {},
) {
    Card(modifier = Modifier
        .height(40.dp),
        elevation = 0.dp,
        onClick = { onClick(CardCategoryData.id)
                  Log.d("CardCategory", "CardCategory: ${CardCategoryData.id}")
                  },
        backgroundColor = if (CardCategoryData.isActive) {
            Color("#FFFFFF".toColorInt())
        } else {
            Color("#ADD5FA".toColorInt())
        },
        shape = RoundedCornerShape(24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Icon(imageVector = Icons.Outlined.Person, contentDescription = "Icon", tint = Color("#3196F3".toColorInt()), modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = CardCategoryData.label, color = if(CardCategoryData.isActive) Color("#3196F3".toColorInt()) else Color("#FFFFFF".toColorInt()),
                fontFamily = FontFamily, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardCategoryPreview() {
    CardCategory()
}
