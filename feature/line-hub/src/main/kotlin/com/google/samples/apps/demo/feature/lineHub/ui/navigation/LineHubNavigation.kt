package com.google.samples.apps.demo.feature.lineHub.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.google.samples.apps.demo.feature.lineHub.ui.LineHubScreen
import kotlinx.serialization.Serializable

@Serializable data object LineHubRoute

fun NavController.navigateToLineHub(navOptions: NavOptions? = null) = navigate(route = LineHubRoute, navOptions)

fun NavGraphBuilder.lineHubScreen(onNavigation: (String) -> Unit) {
    composable<LineHubRoute> {
        LineHubScreen(onNavigation = onNavigation)
    }
}
