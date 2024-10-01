package com.google.samples.apps.demo.coordinator

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.navigation.NavHostController
import com.google.samples.apps.demo.coordinator.landing.LandingNavigationEvent
import com.google.samples.apps.demo.coordinator.landing.LandingNavigationEvent.OnUserDataFethed
import com.google.samples.apps.demo.coordinator.landing.LandingNavigationEventListener
import com.google.samples.apps.demo.feature.auth.AuthEntryActivity
import com.google.samples.apps.demo.feature.welcome.WelcomeEntryActivity
import javax.inject.Inject

class LandingNavigationCoordinator @Inject constructor() : LandingNavigationEventListener {

    private lateinit var activity: Activity
    private var launcher: ActivityResultLauncher<Intent>? = null
    private var navController: NavHostController? = null

    override fun initialize(
        activity: Activity,
        launcher: ActivityResultLauncher<Intent>?,
        navController: NavHostController?,
    ) {
        this.activity = activity
        this.launcher = launcher
        this.navController = navController
    }

    override fun detectStartDestination(intent: Intent?): Any = {}

    override fun onTriggerNavigationEvent(event: LandingNavigationEvent) {
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