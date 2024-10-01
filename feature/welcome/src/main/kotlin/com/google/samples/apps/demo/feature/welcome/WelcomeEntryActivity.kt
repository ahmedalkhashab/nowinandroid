package com.google.samples.apps.demo.feature.welcome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.*
import com.google.samples.apps.demo.feature.welcome.ui.home.navigation.HomeRoute
import com.google.samples.apps.demo.feature.welcome.ui.home.navigation.homeScreen
import com.google.samples.apps.demo.feature.lineHub.ui.navigation.lineHubScreen
import com.google.samples.apps.demo.feature.more.ui.navigation.moreScreen
import com.google.samples.apps.demo.feature.store.StoreNavigationEventListener
import com.google.samples.apps.demo.feature.store.ui.explore.navigation.storeScreen
import com.google.samples.apps.demo.feature.welcome.ui.component.BottomNavigationBar
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WelcomeEntryActivity : ComponentActivity() {

    @Inject
    lateinit var coordinatorStore: StoreNavigationEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations, and go edge-to-edge
        // This also sets up the initial system bar style based on the platform theme
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val navController = rememberNavController()
            coordinatorStore.initialize(
                activity = this@WelcomeEntryActivity,
                navController = navController
            )
            CompositionLocalProvider {
                NiaTheme {
                    Scaffold(
                        bottomBar = {
                            val currentRoute =
                                navController.currentBackStackEntryAsState().value?.destination?.route
                            BottomNavigationBar(currentRoute) { route ->
                                navController.navigate(route) {
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = HomeRoute,
                            modifier = Modifier.padding(innerPadding),
                        ) {
                            homeScreen {}
                            storeScreen { coordinatorStore.onTriggerNavigationEvent(event = it) }
                            lineHubScreen {}
                            moreScreen {}
                        }
                    }
                }
            }
        }
    }

}