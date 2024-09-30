package com.google.samples.apps.demo.feature.payment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.samples.apps.demo.feature.payment.addPaymentMethod.navigation.addPaymentMethodScreen
import com.google.samples.apps.demo.feature.payment.selectPaymentMethod.navigation.SelectPaymentMethodRoute
import com.google.samples.apps.demo.feature.payment.selectPaymentMethod.navigation.selectPaymentMethodScreen
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PaymentEntryActivity : ComponentActivity() {

    @Inject lateinit var coordinator: PaymentNavigationEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations, and go edge-to-edge
        // This also sets up the initial system bar style based on the platform theme
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            val scope = rememberCoroutineScope() // Initialize the scope
            CompositionLocalProvider {
                Scaffold(
                    snackbarHost = { SnackbarHost(snackbarHostState) }
                ) { innerPadding ->
                    NiaTheme {
                        val navController: NavHostController = rememberNavController()
                        val activity = this@PaymentEntryActivity
                        NavHost(
                            navController = navController,
                            startDestination = SelectPaymentMethodRoute,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            selectPaymentMethodScreen { event ->
                                coordinator.onTriggerNavigationEvent(
                                    activity = activity,
                                    navController = navController,
                                    event = event,
                                )
                            }
                            addPaymentMethodScreen { event ->
                                coordinator.onTriggerNavigationEvent(
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