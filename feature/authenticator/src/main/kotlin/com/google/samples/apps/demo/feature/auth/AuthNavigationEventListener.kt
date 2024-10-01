package com.google.samples.apps.demo.feature.auth

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.navigation.NavHostController

interface AuthNavigationEventListener {

    fun initialize(
        activity: Activity,
        launcher: ActivityResultLauncher<Intent>? = null,
        navController: NavHostController?
    )

    fun detectStartDestination(intent: Intent?): Any

    fun onTriggerNavigationEvent(event: AuthNavigationEvent)
}

sealed class AuthNavigationEvent {
    data object OnRegisterClick : AuthNavigationEvent()
    data object OnForgetPasswordClick : AuthNavigationEvent()

    data object OnLoginClick : AuthNavigationEvent()
    data object OnLoginCompleted : AuthNavigationEvent()

    data object OnRegisterCompleted : AuthNavigationEvent()
    data object OnForgetPasswordCompleted : AuthNavigationEvent()
}