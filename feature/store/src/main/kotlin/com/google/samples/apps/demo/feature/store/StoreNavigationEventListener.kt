package com.google.samples.apps.demo.feature.store

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.navigation.NavHostController

interface StoreNavigationEventListener {
    fun onTriggerNavigationEvent(launcher: ActivityResultLauncher<Intent>?=null, activity: Activity, navController: NavHostController?=null, event: StoreNavigationEvent)
}

sealed class StoreNavigationEvent {
    data object OnProceedToPayment : StoreNavigationEvent()
    data object OnCartClicked : StoreNavigationEvent()
    data object OnClearCart : StoreNavigationEvent()
    data object OnContinueShopping : StoreNavigationEvent()
    data object OnPaymentSuccess : StoreNavigationEvent()
    data class OnProductItemClicked(val productId: Long) : StoreNavigationEvent()
}