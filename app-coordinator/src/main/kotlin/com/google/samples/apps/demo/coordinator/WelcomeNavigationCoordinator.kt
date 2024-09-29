package com.google.samples.apps.demo.coordinator

import android.app.Activity
import android.content.Intent
import androidx.navigation.NavHostController
import com.google.samples.apps.demo.feature.store.StoreEntryActivity
import com.google.samples.apps.demo.feature.welcome.WelcomeEntryActivity
import com.google.samples.apps.demo.feature.welcome.WelcomeNavigationEvent
import com.google.samples.apps.demo.feature.welcome.WelcomeNavigationEvent.OnCartClicked
import com.google.samples.apps.demo.feature.welcome.WelcomeNavigationEvent.OnProductItemClicked
import com.google.samples.apps.demo.feature.welcome.WelcomeNavigationEventListener
import javax.inject.Inject

class WelcomeNavigationCoordinator @Inject constructor() : WelcomeNavigationEventListener {

    override fun onTriggerNavigationEvent(
        activity: Activity,
        navController: NavHostController,
        event: WelcomeNavigationEvent
    ) {
        when (event) {
            is OnCartClicked -> if (activity is WelcomeEntryActivity) {
                activity.startActivity(Intent(activity, StoreEntryActivity::class.java))
            }

            is OnProductItemClicked -> if (activity is WelcomeEntryActivity) {
                activity.startActivity(
                    Intent(activity, StoreEntryActivity::class.java).apply {
                        putExtra("productId", event.productId.toString())
                    }
                )
            }
        }
    }

}