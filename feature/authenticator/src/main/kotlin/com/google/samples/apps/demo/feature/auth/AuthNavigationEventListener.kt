package com.google.samples.apps.demo.feature.auth

import android.app.Activity
import androidx.navigation.NavHostController

interface AuthNavigationEventListener {

    fun onTriggerNavigationEvent(
        activity: Activity,
        navController: NavHostController?,
        event: AuthNavigationEvent,
    )
}

sealed class AuthNavigationEvent {
    data object OnRegisterClick : AuthNavigationEvent()
    data object OnForgetPasswordClick : AuthNavigationEvent()

    data object OnLoginClick : AuthNavigationEvent()
    data object OnLoginCompleted : AuthNavigationEvent()

    data object OnRegisterCompleted : AuthNavigationEvent()
    data object OnForgetPasswordCompleted : AuthNavigationEvent()
}