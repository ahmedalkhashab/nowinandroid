package com.google.samples.apps.demo.feature.payment.madaPayment

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEvent

@Composable
fun MadaPaymentMethodScreen(
    paymentId:String,
    viewModel: MadaPaymentMethodViewModel = hiltViewModel(),
    onNavigation: (PaymentNavigationEvent) -> Unit
) {
    MadaPaymentMethodContent(paymentId){ transactionId ->
        viewModel.confirmMadaPaymentMethod(transactionId) {
            onNavigation(PaymentNavigationEvent.OnPaymentCompleted("Mada"))
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun MadaPaymentMethodContent(paymentId:String,onConfirmPaymentMethod: (String) -> Unit) {
    // State variables for the form fields
    var payment by remember { mutableStateOf(paymentId) }

    // State for enabling the Save button
    val isSaveEnabled by derivedStateOf {
        paymentId.isNotEmpty()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 56.dp)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Mada Payment Method",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp),
        )

        // Card Number Input
        OutlinedTextField(
            value = payment,
            onValueChange = { payment = it },
            label = { Text(text = "Transaction Id") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
        )


        Spacer(modifier = Modifier.height(24.dp))

        // Save Button
        Button(
            onClick = {
                onConfirmPaymentMethod(payment)
            },
            enabled = isSaveEnabled,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Confirm Payment")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MadaPaymentMethodScreenPreview() {
    MadaPaymentMethodScreen(paymentId = "") {}
}