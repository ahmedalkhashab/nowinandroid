package com.google.samples.apps.demo.feature.welcome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.view.WindowCompat
import com.google.samples.apps.demo.feature.welcome.ui.WelcomeScreen
import com.google.samples.apps.nowinandroid.core.designsystem.theme.NiaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeEntryActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations, and go edge-to-edge
        // This also sets up the initial system bar style based on the platform theme
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            CompositionLocalProvider {
                NiaTheme {
                    WelcomeScreen(this@WelcomeEntryActivity)
                }
            }
        }
    }

}