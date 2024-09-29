package com.google.samples.apps.demo.coordinator

import android.app.Activity
import android.content.Intent
import androidx.navigation.NavHostController
import com.google.samples.apps.demo.feature.payment.PaymentEntryActivity
import com.google.samples.apps.demo.feature.store.StoreEntryActivity
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnCartClicked
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnClearCart
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnContinueShopping
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnProceedToPayment
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnProductItemClicked
import com.google.samples.apps.demo.feature.store.StoreNavigationEventListener
import com.google.samples.apps.demo.feature.store.ui.cart.navigation.navigateToCartScreen
import com.google.samples.apps.demo.feature.welcome.WelcomeEntryActivity
import javax.inject.Inject

class StoreNavigationCoordinator @Inject constructor() : StoreNavigationEventListener {

    override fun onTriggerNavigationEvent(
        activity: Activity,
        navController: NavHostController,
        event: StoreNavigationEvent
    ) {
        when (event) {
            is OnProceedToPayment ->
                activity.startActivity(Intent(activity, PaymentEntryActivity::class.java))

            is OnClearCart -> navController.popBackStack()

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
                is StoreEntryActivity -> navController.navigateToCartScreen()
                else -> {}
            }

            is OnProductItemClicked -> if (activity is WelcomeEntryActivity) {
                activity.startActivity(
                    Intent(activity, StoreEntryActivity::class.java).apply {
                        putExtra("productId", event.productId.toString())
                    }
                )
            }
        }
    }

}