package com.google.samples.apps.demo.feature.payment.madaPayment.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEvent
import com.google.samples.apps.demo.feature.payment.madaPayment.MadaPaymentMethodScreen
import kotlinx.serialization.Serializable

@Serializable data class MadaPaymentMethodRoute(val paymentId: String)

fun NavController.navigateToMadaPaymentMethodScreen(paymentId: String,
    navOptions: NavOptions? = null) = navigate(route = MadaPaymentMethodRoute(paymentId))

fun NavGraphBuilder.madaPaymentMethodScreen(onNavigation: (PaymentNavigationEvent) -> Unit) {
    composable<MadaPaymentMethodRoute> {
        val args = it.toRoute<MadaPaymentMethodRoute>()
        MadaPaymentMethodScreen(paymentId = args.paymentId, onNavigation = onNavigation)
    }
}
