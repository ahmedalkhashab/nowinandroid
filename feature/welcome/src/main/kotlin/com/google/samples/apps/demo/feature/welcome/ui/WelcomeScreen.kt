package com.google.samples.apps.demo.feature.welcome.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.google.samples.apps.demo.feature.home.ui.HomeScreen
import com.google.samples.apps.demo.feature.lineHub.ui.LineHubScreen
import com.google.samples.apps.demo.feature.more.ui.MoreScreen
import com.google.samples.apps.demo.feature.store.ui.explore.StoreScreen
import com.google.samples.apps.demo.feature.welcome.ui.component.BottomNavigationBar

@Composable
fun WelcomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
            BottomNavigationBar(currentRoute) { route ->
                navController.navigate(route) {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding),
        ) {
            composable("home") { HomeScreen {} }
            composable("store") { StoreScreen {
                // todo - navigate to product details using coordinator
                // navController.navigate("product_details/${product.id}")
            } }
            composable("line_hub") { LineHubScreen {} }
            composable("more") { MoreScreen {} }
        }
    }
}