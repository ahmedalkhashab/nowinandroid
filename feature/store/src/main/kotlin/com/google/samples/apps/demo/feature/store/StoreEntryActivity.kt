package com.google.samples.apps.demo.feature.store

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.samples.apps.demo.feature.store.ui.cart.navigation.CartRoute
import com.google.samples.apps.demo.feature.store.ui.cart.navigation.cartScreen
import com.google.samples.apps.demo.feature.store.ui.productdetails.navigation.ProductDetailsRoute
import com.google.samples.apps.demo.feature.store.ui.productdetails.navigation.productDetailsScreen
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StoreEntryActivity : ComponentActivity() {

    @Inject
    lateinit var coordinator: StoreNavigationEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations, and go edge-to-edge
        // This also sets up the initial system bar style based on the platform theme
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val productId = intent.getStringExtra("productId")
        setContent {
            val activity = this@StoreEntryActivity
            val navController = rememberNavController()
            CompositionLocalProvider {
                NiaTheme {
                    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                            if (result.resultCode == Activity.RESULT_OK) {
                                //do something here
                                coordinator.onTriggerNavigationEvent(
                                    activity = activity,
                                    navController = navController,
                                    event = StoreNavigationEvent.OnPaymentSuccess,
                                )
                            }
                        }
                    Scaffold { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = if (productId != null) ProductDetailsRoute(productId.toLong())
                            else CartRoute,
                            modifier = Modifier.padding(innerPadding),
                        ) {
                            productDetailsScreen { event ->
                                coordinator.onTriggerNavigationEvent(
                                    launcher = launcher,
                                    activity = activity,
                                    navController = navController,
                                    event = event,
                                )
                            }
                            cartScreen { event ->
                                coordinator.onTriggerNavigationEvent(
                                    launcher = launcher,
                                    activity = activity,
                                    navController = navController,
                                    event = event,
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}