package com.google.samples.apps.demo.feature.welcome.ui.store.explore.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.google.samples.apps.demo.feature.welcome.WelcomeNavigationEvent
import com.google.samples.apps.demo.feature.welcome.ui.store.explore.StoreScreen
import kotlinx.serialization.Serializable

@Serializable data object StoreRoute

fun NavController.navigateToStoreScreen(navOptions: NavOptions? = null) = navigate(route = StoreRoute, navOptions)

fun NavGraphBuilder.storeScreen(onNavigation: (WelcomeNavigationEvent) -> Unit) {
    composable<StoreRoute> {
        StoreScreen(onNavigation = onNavigation)
    }
}
