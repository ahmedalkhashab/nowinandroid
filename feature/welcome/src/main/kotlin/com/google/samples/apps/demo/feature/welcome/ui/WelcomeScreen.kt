package com.google.samples.apps.demo.feature.welcome.ui

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.google.samples.apps.demo.feature.store.StoreNavigationEventListener
import com.google.samples.apps.demo.feature.home.ui.navigation.homeScreen
import com.google.samples.apps.demo.feature.home.ui.navigation.HomeRoute
import com.google.samples.apps.demo.feature.lineHub.ui.navigation.lineHubScreen
import com.google.samples.apps.demo.feature.lineHub.ui.navigation.LineHubRoute
import com.google.samples.apps.demo.feature.more.ui.navigation.moreScreen
import com.google.samples.apps.demo.feature.more.ui.navigation.MoreRoute
import com.google.samples.apps.demo.feature.store.ui.explore.navigation.storeScreen
import com.google.samples.apps.demo.feature.store.ui.explore.navigation.StoreRoute
import com.google.samples.apps.demo.feature.welcome.ui.component.BottomNavigationBar

@Composable
fun WelcomeScreen(activity: Activity, coordinator: StoreNavigationEventListener) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            val currentRoute =
                navController.currentBackStackEntryAsState().value?.destination?.route
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
            startDestination = HomeRoute,
            modifier = Modifier.padding(innerPadding),
        ) {
            homeScreen {

            }
            storeScreen { event ->
                coordinator.onTriggerNavigationEvent(
                    activity = activity,
                    navController = navController,
                    event = event
                )
            }
            lineHubScreen {

            }
            moreScreen {

            }
        }
    }
}