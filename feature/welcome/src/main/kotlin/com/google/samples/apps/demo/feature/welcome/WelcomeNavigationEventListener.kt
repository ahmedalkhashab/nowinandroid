package com.google.samples.apps.demo.feature.welcome

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.navigation.NavHostController

interface WelcomeNavigationEventListener {

    fun initialize(
        activity: Activity,
        launcher: ActivityResultLauncher<Intent>? = null,
        navController: NavHostController?
    )

    fun detectStartDestination(intent: Intent?): Any

    fun onTriggerNavigationEvent(
        activity: Activity,
        navController: NavHostController?,
        event: WelcomeNavigationEvent,
    )
}

sealed class WelcomeNavigationEvent {
    data object OnCartClicked : WelcomeNavigationEvent()
    data class OnProductItemClicked(val productId: Long) : WelcomeNavigationEvent()
}