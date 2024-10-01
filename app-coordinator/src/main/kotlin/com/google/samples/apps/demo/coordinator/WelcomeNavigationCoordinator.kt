package com.google.samples.apps.demo.coordinator

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.navigation.NavHostController
import com.google.samples.apps.demo.feature.welcome.ui.home.navigation.HomeRoute
import com.google.samples.apps.demo.feature.store.StoreEntryActivity
import com.google.samples.apps.demo.feature.welcome.WelcomeNavigationEvent
import com.google.samples.apps.demo.feature.welcome.WelcomeNavigationEvent.OnCartClicked
import com.google.samples.apps.demo.feature.welcome.WelcomeNavigationEvent.OnProductItemClicked
import com.google.samples.apps.demo.feature.welcome.WelcomeNavigationEventListener
import javax.inject.Inject

class WelcomeNavigationCoordinator @Inject constructor() : WelcomeNavigationEventListener {

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

    override fun detectStartDestination(intent: Intent?): Any = HomeRoute

    override fun onTriggerNavigationEvent(event: WelcomeNavigationEvent) {
        when (event) {
            is OnCartClicked ->
                activity.startActivity(Intent(activity, StoreEntryActivity::class.java))

            is OnProductItemClicked -> activity.startActivity(
                Intent(activity, StoreEntryActivity::class.java).apply {
                    putExtra("productId", event.productId.toString())
                }
            )
        }
    }

}