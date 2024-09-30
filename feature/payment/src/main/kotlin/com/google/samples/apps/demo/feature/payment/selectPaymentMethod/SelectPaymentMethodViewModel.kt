package com.google.samples.apps.demo.feature.payment.selectPaymentMethod

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectPaymentMethodViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun confirmPayment(onConfirmPaymentCompleted: (String) -> Unit) = viewModelScope.launch{
        delay(1000)
        onConfirmPaymentCompleted("Visa Card")
    }

}