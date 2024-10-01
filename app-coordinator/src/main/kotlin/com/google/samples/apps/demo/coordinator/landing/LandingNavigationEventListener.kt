package com.google.samples.apps.demo.coordinator.landing

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.navigation.NavHostController

interface LandingNavigationEventListener {

    fun initialize(
        activity: Activity,
        launcher: ActivityResultLauncher<Intent>? = null,
        navController: NavHostController?
    )

    fun detectStartDestination(intent: Intent?): Any

    fun onTriggerNavigationEvent(event: LandingNavigationEvent)
}

sealed class LandingNavigationEvent {
    data class OnUserDataFethed(val userId: Long?) : LandingNavigationEvent()
}