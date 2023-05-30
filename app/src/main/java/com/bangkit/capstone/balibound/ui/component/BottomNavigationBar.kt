package com.bangkit.capstone.balibound.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bangkit.capstone.balibound.ui.navigation.BottomNavigationItem
import com.bangkit.capstone.balibound.ui.theme.Blue500

@Composable
fun BottomNavigationBar(
    navController: NavController = rememberNavController()
) {
    val items = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Profile
    )

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Blue500,

    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEachIndexed { index, item ->

            BottomNavigationItem(icon = {
                Icon(
                    tint = if (currentRoute == item.route) Blue500 else Color("#858D9D".toColorInt()),
                    imageVector = currentRoute?.let {
                        if (currentRoute == item.route) item.selectedIcon else item.icon
                    } ?: item.icon,
                    contentDescription = item.title,
                    modifier = Modifier.size(24.dp))
            }, selected = currentRoute == item.route, onClick = {
                if (currentRoute != item.route) {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }, label = {
                if (currentRoute == item.route) Text(text = item.title, color = Blue500)
                else Text(
                    text = item.title, color = Color("#858D9D".toColorInt())
                )
            })
        }
    }
}
