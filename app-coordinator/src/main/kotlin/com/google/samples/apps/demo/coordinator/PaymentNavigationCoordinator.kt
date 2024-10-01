package com.google.samples.apps.demo.coordinator

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.navigation.NavHostController
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEvent
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEvent.OnAddPaymentMethodClick
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEvent.OnPaymentCompleted
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEvent.OnSavePaymentMethodClick
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEventListener
import com.google.samples.apps.demo.feature.payment.addPaymentMethod.navigation.navigateToAddPaymentMethodScreen
import com.google.samples.apps.demo.feature.payment.selectPaymentMethod.navigation.SelectPaymentMethodRoute
import javax.inject.Inject

class PaymentNavigationCoordinator @Inject constructor() : PaymentNavigationEventListener {

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

    override fun detectStartDestination(intent: Intent?): Any = SelectPaymentMethodRoute

    override fun onTriggerNavigationEvent(event: PaymentNavigationEvent) {
        when (event) {
            is OnSavePaymentMethodClick -> navController?.popBackStack()
            is OnAddPaymentMethodClick -> navController?.navigateToAddPaymentMethodScreen()
            is OnPaymentCompleted -> {
                // event.paymentMethod // Handle payment completion and result
                activity.setResult(Activity.RESULT_OK)
                activity.finish()
            }

        }
    }

}