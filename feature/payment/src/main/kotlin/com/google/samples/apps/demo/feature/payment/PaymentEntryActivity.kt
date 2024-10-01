package com.google.samples.apps.demo.feature.payment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
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
            val navController: NavHostController = rememberNavController()
            coordinator.initialize(
                activity = this@PaymentEntryActivity,
                navController = navController
            )
            CompositionLocalProvider {
                Scaffold { innerPadding ->
                    NiaTheme {
                        NavHost(
                            navController = navController,
                            startDestination = SelectPaymentMethodRoute,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            selectPaymentMethodScreen { coordinator.onTriggerNavigationEvent(event = it) }
                            addPaymentMethodScreen { coordinator.onTriggerNavigationEvent(event = it) }
                        }
                    }
                }
            }
        }
    }

}