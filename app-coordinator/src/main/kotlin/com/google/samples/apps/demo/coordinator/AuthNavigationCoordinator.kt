package com.google.samples.apps.demo.coordinator

import android.app.Activity
import android.content.Intent
import androidx.navigation.NavHostController
import com.google.samples.apps.demo.feature.auth.AuthNavigationEvent
import com.google.samples.apps.demo.feature.auth.AuthNavigationEvent.OnForgetPasswordClick
import com.google.samples.apps.demo.feature.auth.AuthNavigationEvent.OnForgetPasswordCompleted
import com.google.samples.apps.demo.feature.auth.AuthNavigationEvent.OnLoginClick
import com.google.samples.apps.demo.feature.auth.AuthNavigationEvent.OnLoginCompleted
import com.google.samples.apps.demo.feature.auth.AuthNavigationEvent.OnRegisterClick
import com.google.samples.apps.demo.feature.auth.AuthNavigationEvent.OnRegisterCompleted
import com.google.samples.apps.demo.feature.auth.AuthNavigationEventListener
import com.google.samples.apps.demo.feature.auth.forgetPassword.navigation.navigateToForgetPasswordScreen
import com.google.samples.apps.demo.feature.auth.register.navigation.navigateToRegisterScreen
import com.google.samples.apps.demo.feature.welcome.WelcomeEntryActivity
import javax.inject.Inject

class AuthNavigationCoordinator @Inject constructor() : AuthNavigationEventListener {

    override fun onTriggerNavigationEvent(
        activity: Activity,
        navController: NavHostController?,
        event: AuthNavigationEvent,
    ) {
        when (event) {
            OnForgetPasswordClick -> navController?.navigateToForgetPasswordScreen()
            OnForgetPasswordCompleted -> navController?.popBackStack()

            OnLoginClick -> navController?.popBackStack()
            OnLoginCompleted -> {
                activity.finish()
                activity.startActivity(Intent(activity, WelcomeEntryActivity::class.java))
            }

            OnRegisterClick -> navController?.navigateToRegisterScreen()
            OnRegisterCompleted -> {
                activity.finish()
                activity.startActivity(Intent(activity, WelcomeEntryActivity::class.java))
            }
        }
    }
}