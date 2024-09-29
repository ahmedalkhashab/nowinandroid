package com.google.samples.apps.demo.feature.store

import android.app.Activity
import androidx.navigation.NavHostController

interface StoreNavigationEventListener {
    fun onTriggerNavigationEvent(activity: Activity, navController: NavHostController, event: StoreNavigationEvent)
}

sealed class StoreNavigationEvent {
    data object OnProceedToPayment : StoreNavigationEvent()
    data object OnCartClicked : StoreNavigationEvent()
    data object OnClearCart : StoreNavigationEvent()
    data object OnContinueShopping : StoreNavigationEvent()
    data class OnProductItemClicked(val productId: Long) : StoreNavigationEvent()
}