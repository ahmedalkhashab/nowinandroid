package com.google.samples.apps.demo.feature.payment

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.navigation.NavHostController

interface PaymentNavigationEventListener {

    fun initialize(
        activity: Activity,
        launcher: ActivityResultLauncher<Intent>? = null,
        navController: NavHostController?
    )

    fun detectStartDestination(intent: Intent?): Any

    fun onTriggerNavigationEvent(event: PaymentNavigationEvent)
}

sealed class PaymentNavigationEvent {
    data object OnAddPaymentMethodClick : PaymentNavigationEvent()
    data class OnPaymentCompleted(val paymentMethod: String) : PaymentNavigationEvent()

    data object OnSavePaymentMethodClick : PaymentNavigationEvent()
}