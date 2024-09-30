package com.google.samples.apps.demo.feature.payment.addPaymentMethod.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEvent
import com.google.samples.apps.demo.feature.payment.addPaymentMethod.AddPaymentMethodScreen
import kotlinx.serialization.Serializable

@Serializable data object AddPaymentMethodRoute

fun NavController.navigateToAddPaymentMethodScreen(navOptions: NavOptions? = null) = navigate(route = AddPaymentMethodRoute, navOptions = navOptions)

fun NavGraphBuilder.addPaymentMethodScreen(onNavigation: (PaymentNavigationEvent) -> Unit) {
    composable<AddPaymentMethodRoute> {
        AddPaymentMethodScreen(onNavigation = onNavigation)
    }
}
