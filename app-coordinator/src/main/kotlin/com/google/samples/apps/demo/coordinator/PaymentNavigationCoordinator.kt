package com.google.samples.apps.demo.coordinator

import android.app.Activity
import androidx.navigation.NavHostController
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEvent
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEvent.OnAddPaymentMethodClick
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEvent.OnPaymentCompleted
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEvent.OnSavePaymentMethodClick
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEventListener
import com.google.samples.apps.demo.feature.payment.addPaymentMethod.navigation.navigateToAddPaymentMethodScreen
import javax.inject.Inject

class PaymentNavigationCoordinator @Inject constructor() : PaymentNavigationEventListener {

    override fun onTriggerNavigationEvent(
        activity: Activity,
        navController: NavHostController,
        event: PaymentNavigationEvent,
    ) {
        when (event) {
            is OnSavePaymentMethodClick -> navController.popBackStack()
            is OnAddPaymentMethodClick -> navController.navigateToAddPaymentMethodScreen()
            is OnPaymentCompleted -> {
                // event.paymentMethod // Handle payment completion and result
                activity.setResult(Activity.RESULT_OK)
                activity.finish()
            }

        }
    }
}