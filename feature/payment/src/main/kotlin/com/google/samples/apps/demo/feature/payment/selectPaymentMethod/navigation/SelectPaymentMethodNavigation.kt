package com.google.samples.apps.demo.feature.payment.selectPaymentMethod.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEvent
import com.google.samples.apps.demo.feature.payment.selectPaymentMethod.SelectPaymentMethodScreen
import kotlinx.serialization.Serializable

@Serializable data object SelectPaymentMethodRoute

fun NavController.navigateToSelectPaymentMethodScreen() = navigate(route = SelectPaymentMethodRoute)

fun NavGraphBuilder.selectPaymentMethodScreen(onNavigation: (PaymentNavigationEvent) -> Unit) {
    composable<SelectPaymentMethodRoute>{
        SelectPaymentMethodScreen(onNavigation = onNavigation)
    }
}
