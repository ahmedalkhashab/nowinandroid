package com.google.samples.apps.demo.feature.auth.forgetPassword.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.google.samples.apps.demo.feature.auth.AuthNavigationEvent
import com.google.samples.apps.demo.feature.auth.forgetPassword.ForgetPasswordScreen
import kotlinx.serialization.Serializable

@Serializable data object ForgetPasswordRoute

fun NavController.navigateToForgetPasswordScreen(navOptions: NavOptions? = null) = navigate(route = ForgetPasswordRoute, navOptions = navOptions)

fun NavGraphBuilder.forgetPasswordRouteScreen(onNavigation: (AuthNavigationEvent) -> Unit) {
    composable<ForgetPasswordRoute>{
        ForgetPasswordScreen(onNavigation = onNavigation)
    }
}