package com.google.samples.apps.demo.feature.welcome

import android.app.Activity
import androidx.navigation.NavHostController

interface WelcomeNavigationEventListener {
    fun onTriggerNavigationEvent(activity: Activity, navController: NavHostController, event: WelcomeNavigationEvent)
}

sealed class WelcomeNavigationEvent {
    data object OnCartClicked : WelcomeNavigationEvent()
    data class OnProductItemClicked(val productId: Long) : WelcomeNavigationEvent()
}