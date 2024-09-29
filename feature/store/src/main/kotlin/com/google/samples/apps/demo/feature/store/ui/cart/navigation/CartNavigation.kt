package com.google.samples.apps.demo.feature.store.ui.cart.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.google.samples.apps.demo.feature.store.ui.cart.CartScreen
import kotlinx.serialization.Serializable

@Serializable data object CartRoute

fun NavController.navigateToCart(navOptions: NavOptions? = null) = navigate(route = CartRoute, navOptions)

fun NavGraphBuilder.cartScreen(onNavigation: () -> Unit) {
    composable<CartRoute> {
        CartScreen(onNavigation = onNavigation)
    }
}
