package com.google.samples.apps.demo.feature.auth.register

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    fun registerUser(username: String, password: String, onRegisterCompleted: () -> Unit) =
        viewModelScope.launch {
            delay(1000)
            onRegisterCompleted()
        }

}