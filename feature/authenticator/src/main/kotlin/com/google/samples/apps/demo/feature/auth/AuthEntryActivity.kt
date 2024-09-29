package com.google.samples.apps.demo.feature.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.core.view.WindowCompat
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.samples.apps.demo.feature.auth.forgetPassword.navigation.forgetPasswordRouteScreen
import com.google.samples.apps.demo.feature.auth.forgetPassword.navigation.navigateToForgetPasswordScreen
import com.google.samples.apps.demo.feature.auth.login.navigation.LoginRoute
import com.google.samples.apps.demo.feature.auth.login.navigation.loginRouteScreen
import com.google.samples.apps.demo.feature.auth.register.navigation.navigateToRegisterScreen
import com.google.samples.apps.demo.feature.auth.register.navigation.registerRouteScreen

@AndroidEntryPoint
class AuthEntryActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations, and go edge-to-edge
        // This also sets up the initial system bar style based on the platform theme
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {

            val navController: NavHostController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = LoginRoute,
            ) {
                loginRouteScreen(
                    onLoginClick = { userName, password -> /*navigator should send event here*/ },
                    onRegisterClick = { navController.navigateToRegisterScreen() },
                    onForgetPasswordClick = { navController.navigateToForgetPasswordScreen() },
                )

                registerRouteScreen { userName, password -> navController.popBackStack() }

                forgetPasswordRouteScreen { navController.popBackStack() }
            }
        }
    }
}