package com.google.samples.apps.demo.feature.payment.addPaymentMethod

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPaymentMethodViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    fun addPaymentMethod(
        cardNumber: String,
        expirationDate: String,
        cvv: String,
        onPaymentMethodAdded: () -> Unit,
    ) = viewModelScope.launch {
        delay(1000)
        onPaymentMethodAdded()
    }
}