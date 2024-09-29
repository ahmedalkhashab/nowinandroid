package com.google.samples.apps.demo.feature.store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.samples.apps.demo.feature.store.ui.cart.CartScreen
import com.google.samples.apps.demo.feature.store.ui.productdetails.ProductDetailsScreen
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoreEntryActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations, and go edge-to-edge
        // This also sets up the initial system bar style based on the platform theme
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val navController = rememberNavController()
            CompositionLocalProvider {
                NiaTheme {
                    NavHost(
                        navController = navController,
                        startDestination = "cart",
                        modifier = Modifier,
                    ) {
                        composable("product_details/{productId}") { backStackEntry ->
                            val productId =
                                backStackEntry.arguments?.getString("productId")?.toLong()
                            ProductDetailsScreen(productId) {
                                navController.navigate("cart")
                            }
                        }
                        composable("cart") { CartScreen {} }
                    }
                }
            }
        }
    }

}