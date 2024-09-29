package com.google.samples.apps.demo.feature.store.ui.productdetails.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.google.samples.apps.demo.feature.store.ui.productdetails.ProductDetailsScreen
import com.google.samples.apps.nowinandroid.core.model.data.Product
import kotlinx.serialization.Serializable

@Serializable data class ProductDetailsRoute(val productId: Long)

fun NavController.navigateToProductDetails(
    productId: Long,
    navOptions: NavOptions? = null,
) = navigate(route = ProductDetailsRoute(productId), navOptions)

fun NavGraphBuilder.productDetailsScreen(onNavigation: (Product) -> Unit) {
    composable<ProductDetailsRoute> {
        val args = it.toRoute<ProductDetailsRoute>()
        ProductDetailsScreen(productId = args.productId, onNavigation = onNavigation)
    }
}


