package com.google.samples.apps.demo.coordinator

import android.app.Activity
import android.content.Intent
import androidx.navigation.NavHostController
import com.google.samples.apps.demo.coordinator.landing.LandingNavigationEvent
import com.google.samples.apps.demo.coordinator.landing.LandingNavigationEvent.OnUserDataFethed
import com.google.samples.apps.demo.coordinator.landing.LandingNavigationEventListener
import com.google.samples.apps.demo.feature.auth.AuthEntryActivity
import com.google.samples.apps.demo.feature.welcome.WelcomeEntryActivity
import javax.inject.Inject

class LandingNavigationCoordinator @Inject constructor() : LandingNavigationEventListener {

    override fun onTriggerNavigationEvent(
        activity: Activity,
        navController: NavHostController?,
        event: LandingNavigationEvent,
    ) {
        when (event) {
            is OnUserDataFethed -> {
                activity.startActivity(
                    Intent(
                        activity,
                        when (event.userId) {
                            null -> AuthEntryActivity::class.java
                            else -> WelcomeEntryActivity::class.java
                        },
                    ),
                )
                activity.finish()
            }
        }
    }
}