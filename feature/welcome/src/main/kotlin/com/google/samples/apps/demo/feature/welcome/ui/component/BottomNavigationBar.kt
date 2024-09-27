package com.google.samples.apps.demo.feature.welcome.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.SimCard
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text

@Composable
fun BottomNavigationBar(
    currentRoute: String?,
    onNavigationItemClicked: (String) -> Unit
) {
    val items = listOf(
        BottomNavItem("home", Icons.Default.Home, "Home"),
        BottomNavItem("store", Icons.Default.ShoppingCart, "Store"),
        BottomNavItem("line_hub", Icons.Default.SimCard, "Line Hub"),
        BottomNavItem("more", Icons.Default.MoreHoriz, "More")
    )
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                selected = currentRoute == item.route,
                label = { Text(item.title) },
                onClick = { onNavigationItemClicked(item.route) },
            )
        }
    }
}

data class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val title: String
)