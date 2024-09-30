package com.google.samples.apps.demo.feature.auth.register.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.google.samples.apps.demo.feature.auth.AuthNavigationEvent
import com.google.samples.apps.demo.feature.auth.register.RegisterScreen
import kotlinx.serialization.Serializable

@Serializable data object RegisterRoute

fun NavController.navigateToRegisterScreen(navOptions: NavOptions? = null) =
    navigate(route = RegisterRoute, navOptions = navOptions)

fun NavGraphBuilder.registerRouteScreen(onNavigation: (AuthNavigationEvent) -> Unit) {
    composable<RegisterRoute> {
        RegisterScreen(onNavigation = onNavigation)
    }
}