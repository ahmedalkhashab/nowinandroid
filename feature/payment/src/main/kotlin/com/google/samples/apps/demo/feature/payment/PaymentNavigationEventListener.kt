package com.google.samples.apps.demo.feature.payment

import android.app.Activity
import androidx.navigation.NavHostController

interface PaymentNavigationEventListener {

    fun onTriggerNavigationEvent(
        activity: Activity,
        navController: NavHostController,
        event: PaymentNavigationEvent,
    )
}

sealed class PaymentNavigationEvent {
    data object OnSavePaymentMethodClick : PaymentNavigationEvent()
    data object OnAddPaymentMethodClick : PaymentNavigationEvent()
    data object OnConfirmPaymentClick : PaymentNavigationEvent()
}