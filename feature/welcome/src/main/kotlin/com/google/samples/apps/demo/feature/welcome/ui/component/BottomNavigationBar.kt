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
import com.google.samples.apps.demo.feature.welcome.ui.home.navigation.HomeRoute
import com.google.samples.apps.demo.feature.lineHub.ui.navigation.LineHubRoute
import com.google.samples.apps.demo.feature.more.ui.navigation.MoreRoute
import com.google.samples.apps.demo.feature.store.ui.explore.navigation.StoreRoute

@Composable
fun BottomNavigationBar(
    currentRoute: String?,
    onNavigationItemClicked: (Any) -> Unit
) {
    val items = listOf(
        BottomNavItem(HomeRoute, Icons.Default.Home, "Home"),
        BottomNavItem(StoreRoute, Icons.Default.ShoppingCart, "Store"),
        BottomNavItem(LineHubRoute, Icons.Default.SimCard, "Line Hub"),
        BottomNavItem(MoreRoute, Icons.Default.MoreHoriz, "More")
    )
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                selected = currentRoute == item.route.javaClass.name,
                label = { Text(item.title) },
                onClick = { onNavigationItemClicked(item.route) },
            )
        }
    }
}

data class BottomNavItem(
    val route: Any,
    val icon: ImageVector,
    val title: String
)