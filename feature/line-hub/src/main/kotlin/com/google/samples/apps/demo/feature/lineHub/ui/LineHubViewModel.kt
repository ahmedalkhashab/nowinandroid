package com.google.samples.apps.demo.feature.lineHub.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LineHubViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel()