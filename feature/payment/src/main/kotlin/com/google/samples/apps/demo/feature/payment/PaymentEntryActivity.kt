package com.google.samples.apps.demo.feature.payment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.samples.apps.demo.feature.payment.addPaymentMethod.navigation.addPaymentMethodScreen
import com.google.samples.apps.demo.feature.payment.addPaymentMethod.navigation.navigateToAddPaymentMethodScreen
import com.google.samples.apps.demo.feature.payment.selectPaymentMethod.navigation.SelectPaymentMethodRoute
import com.google.samples.apps.demo.feature.payment.selectPaymentMethod.navigation.navigateToSelectPaymentMethodScreen
import com.google.samples.apps.demo.feature.payment.selectPaymentMethod.navigation.selectPaymentMethodScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentEntryActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations, and go edge-to-edge
        // This also sets up the initial system bar style based on the platform theme
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val navController: NavHostController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = SelectPaymentMethodRoute,
            ) {
                selectPaymentMethodScreen(
                    onAddPaymentMethod = {navController.navigateToAddPaymentMethodScreen()}
                    , onCardSelectClick = {})
                addPaymentMethodScreen(onSavePaymentMethod = {_,_,_ -> navController.popBackStack()})
            }
        }
    }
}