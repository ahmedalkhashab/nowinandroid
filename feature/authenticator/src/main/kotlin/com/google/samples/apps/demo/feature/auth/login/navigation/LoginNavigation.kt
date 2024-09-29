package com.google.samples.apps.demo.feature.auth.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.google.samples.apps.demo.feature.auth.login.LoginScreen
import com.google.samples.apps.nowinandroid.core.notifications.DEEP_LINK_URI_PATTERN
import kotlinx.serialization.Serializable

@Serializable data object LoginRoute

fun NavController.navigateToLoginScreen(navOptions: NavOptions) = navigate(route = LoginRoute, navOptions)

fun NavGraphBuilder.loginRouteScreen(onLoginClick: (String,String) -> Unit, onRegisterClick: () -> Unit,onForgetPasswordClick: () -> Unit) {
    composable<LoginRoute>(
        deepLinks = listOf(
            navDeepLink {
                /**
                 * This destination has a deep link that enables a specific news resource to be
                 * opened from a notification (@see SystemTrayNotifier for more). The news resource
                 * ID is sent in the URI rather than being modelled in the route type because it's
                 * transient data (stored in SavedStateHandle) that is cleared after the user has
                 * opened the news resource.
                 */
                uriPattern = DEEP_LINK_URI_PATTERN
            },
        ),
    ) {
        LoginScreen(onLoginClick,onRegisterClick, onForgetPasswordClick)
    }
}
