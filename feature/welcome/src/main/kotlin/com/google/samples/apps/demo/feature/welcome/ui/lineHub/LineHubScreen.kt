package com.google.samples.apps.demo.feature.welcome.ui.lineHub

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LineHubScreen(
    modifier: Modifier = Modifier,
    viewModel: LineHubViewModel = hiltViewModel(),
    onNavigation: (String) -> Unit
) {
    LineHubContent()
}

@Composable
internal fun LineHubContent() {
    // Placeholder for Line Hub content
    Text(
        "Line Hub Screen",
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.padding(16.dp)
    )
}