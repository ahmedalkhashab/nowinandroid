package com.google.samples.apps.demo.feature.store.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun StoreScreen(
    modifier: Modifier = Modifier,
    viewModel: StoreViewModel = hiltViewModel(),
    onNavigation: (String) -> Unit
) {
    StoreContent()
}

@Composable
internal fun StoreContent() {
    // Placeholder for More content
    Text(
        "More Screen",
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.padding(16.dp)
    )
}