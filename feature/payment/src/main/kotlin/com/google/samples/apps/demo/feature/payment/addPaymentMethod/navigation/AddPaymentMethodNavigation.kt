package com.google.samples.apps.demo.feature.payment.addPaymentMethod.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.google.samples.apps.demo.feature.payment.addPaymentMethod.AddPaymentMethodScreen
import com.google.samples.apps.nowinandroid.core.notifications.DEEP_LINK_URI_PATTERN
import kotlinx.serialization.Serializable

@Serializable data object AddPaymentMethodRoute

fun NavController.navigateToAddPaymentMethodScreen() = navigate(route = AddPaymentMethodRoute)

fun NavGraphBuilder.addPaymentMethodScreen(onSavePaymentMethod: (String, String, String) -> Unit) {
    composable<AddPaymentMethodRoute>(
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
        AddPaymentMethodScreen(onSavePaymentMethod)
    }
}
