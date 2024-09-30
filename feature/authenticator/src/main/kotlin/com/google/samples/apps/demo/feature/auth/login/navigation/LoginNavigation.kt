package com.google.samples.apps.demo.feature.auth.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.google.samples.apps.demo.feature.auth.AuthNavigationEvent
import com.google.samples.apps.demo.feature.auth.login.LoginScreen
import kotlinx.serialization.Serializable

@Serializable data object LoginRoute

fun NavController.navigateToLoginScreen(navOptions: NavOptions? = null) =
    navigate(route = LoginRoute, navOptions)

fun NavGraphBuilder.loginRouteScreen(onNavigation: (AuthNavigationEvent) -> Unit) {
    composable<LoginRoute> {
        LoginScreen(onNavigation = onNavigation)
    }
}
