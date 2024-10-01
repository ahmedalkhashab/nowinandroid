package com.google.samples.apps.demo.feature.welcome.ui.more.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.google.samples.apps.demo.feature.welcome.ui.more.MoreScreen
import kotlinx.serialization.Serializable

@Serializable data object MoreRoute

fun NavController.navigateToMoreScreen(navOptions: NavOptions? = null) = navigate(route = MoreRoute, navOptions)

fun NavGraphBuilder.moreScreen(onNavigation: (String) -> Unit) {
    composable<MoreRoute> {
        MoreScreen(onNavigation = onNavigation)
    }
}
