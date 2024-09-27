package com.google.samples.apps.demo.feature.more.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MoreScreen(
    modifier: Modifier = Modifier,
    viewModel: MoreViewModel = hiltViewModel(),
    onNavigation: (String) -> Unit
) {
    MoreContent()
}

@Composable
internal fun MoreContent() {
    // Placeholder for More content
    Text(
        "More Screen",
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.padding(16.dp)
    )
}