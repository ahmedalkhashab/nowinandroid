package com.google.samples.apps.demo.feature.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.samples.apps.demo.feature.auth.forgetPassword.navigation.forgetPasswordRouteScreen
import com.google.samples.apps.demo.feature.auth.login.navigation.LoginRoute
import com.google.samples.apps.demo.feature.auth.login.navigation.loginRouteScreen
import com.google.samples.apps.demo.feature.auth.register.navigation.registerRouteScreen
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject

@AndroidEntryPoint
class AuthEntryActivity : ComponentActivity() {

    @Inject lateinit var coordinator: AuthNavigationEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations, and go edge-to-edge
        // This also sets up the initial system bar style based on the platform theme
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val activity = this@AuthEntryActivity
            val navController: NavHostController = rememberNavController()
            CompositionLocalProvider {
                NiaTheme {
                    NavHost(
                        navController = navController,
                        startDestination = LoginRoute,
                    ) {
                        loginRouteScreen { event ->
                            coordinator.onTriggerNavigationEvent(
                                activity = activity,
                                navController = navController,
                                event = event,
                            )
                        }
                        registerRouteScreen { event ->
                            coordinator.onTriggerNavigationEvent(
                                activity = activity,
                                navController = navController,
                                event = event,
                            )
                        }
                        forgetPasswordRouteScreen { event ->
                            coordinator.onTriggerNavigationEvent(
                                activity = activity,
                                navController = navController,
                                event = event,
                            )
                        }
                    }
                }
            }
        }
    }

}