package com.google.samples.apps.demo.coordinator.landing

import android.app.Activity
import androidx.navigation.NavHostController

interface LandingNavigationEventListener {
    fun onTriggerNavigationEvent(
        activity: Activity,
        navController: NavHostController?,
        event: LandingNavigationEvent,
    )
}

sealed class LandingNavigationEvent {
    data class OnUserDataFethed(val userId: Long?) : LandingNavigationEvent()
}