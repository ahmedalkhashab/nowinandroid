package com.google.samples.apps.demo.feature.auth.forgetPassword

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgetPasswordViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    fun forgetPassword(username: String, onForgetPasswordCompleted: () -> Unit) =
        viewModelScope.launch {
            delay(1000)
            onForgetPasswordCompleted()
        }

}