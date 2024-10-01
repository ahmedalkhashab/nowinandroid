package com.google.samples.apps.demo.feature.welcome.ui.more

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoreViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel()