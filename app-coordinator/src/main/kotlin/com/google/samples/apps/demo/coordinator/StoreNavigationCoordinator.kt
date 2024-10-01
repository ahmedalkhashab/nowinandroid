package com.google.samples.apps.demo.coordinator

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.navigation.NavHostController
import com.google.samples.apps.demo.feature.payment.PaymentEntryActivity
import com.google.samples.apps.demo.feature.store.StoreEntryActivity
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnCartClicked
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnClearCart
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnContinueShopping
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnPaymentSuccess
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnProceedToPayment
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnProductItemClicked
import com.google.samples.apps.demo.feature.store.StoreNavigationEventListener
import com.google.samples.apps.demo.feature.store.ui.cart.navigation.CartRoute
import com.google.samples.apps.demo.feature.store.ui.cart.navigation.navigateToCartScreen
import com.google.samples.apps.demo.feature.store.ui.productdetails.navigation.ProductDetailsRoute
import com.google.samples.apps.demo.feature.welcome.WelcomeEntryActivity
import javax.inject.Inject

class StoreNavigationCoordinator @Inject constructor() : StoreNavigationEventListener {

    private lateinit var activity: Activity
    private var launcher: ActivityResultLauncher<Intent>? = null
    private var navController: NavHostController? = null

    override fun initialize(
        activity: Activity,
        launcher: ActivityResultLauncher<Intent>?,
        navController: NavHostController?,
    ) {
        this.activity = activity
        this.launcher = launcher
        this.navController = navController
    }

    override fun detectStartDestination(intent: Intent?): Any = when (intent) {
        null -> CartRoute
        else -> intent.getStringExtra("productId")?.let { productId ->
            ProductDetailsRoute(productId.toLong())
        } ?: run { CartRoute }
    }

    override fun onTriggerNavigationEvent(event: StoreNavigationEvent) {
        when (event) {
            is OnProceedToPayment ->
                launcher?.launch(Intent(activity, PaymentEntryActivity::class.java))

            is OnClearCart -> navController?.popBackStack()

            is OnContinueShopping -> {
                if (activity is StoreEntryActivity) {
                    activity.finish()
                    activity.startActivity(Intent(activity, PaymentEntryActivity::class.java))
                }
            }

            is OnCartClicked -> when (activity) {
                is WelcomeEntryActivity -> activity.startActivity(
                    Intent(activity, StoreEntryActivity::class.java)
                )
                is StoreEntryActivity -> navController?.navigateToCartScreen()
                else -> {}
            }

            is OnProductItemClicked -> if (activity is WelcomeEntryActivity) {
                activity.startActivity(
                    Intent(activity, StoreEntryActivity::class.java).apply {
                        putExtra("productId", event.productId.toString())
                    }
                )
            }

            is OnPaymentSuccess -> activity.finish()
        }
    }

}