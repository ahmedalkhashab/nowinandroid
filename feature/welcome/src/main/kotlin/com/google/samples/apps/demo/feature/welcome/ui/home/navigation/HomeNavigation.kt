package com.google.samples.apps.demo.feature.welcome.ui.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.google.samples.apps.demo.feature.welcome.ui.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable data object HomeRoute

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) = navigate(route = HomeRoute, navOptions)

fun NavGraphBuilder.homeScreen(onNavigation: (String) -> Unit) {
    composable<HomeRoute> {
        HomeScreen(onNavigation = onNavigation)
    }
}