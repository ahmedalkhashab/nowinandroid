package com.google.samples.apps.demo.feature.payment.addPaymentMethod

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEvent

@Composable
fun AddPaymentMethodScreen(
    viewModel: AddPaymentMethodViewModel = hiltViewModel(),
    onNavigation: (PaymentNavigationEvent) -> Unit
) {
    AddPaymentMethodContent{ cardNumber, expirationDate, cvv ->
        viewModel.addPaymentMethod(cardNumber, expirationDate, cvv) {
            onNavigation(PaymentNavigationEvent.OnSavePaymentMethodClick)
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun AddPaymentMethodContent(onSavePaymentMethod: (String, String, String) -> Unit) {
    // State variables for the form fields
    var cardNumber by remember { mutableStateOf("") }
    var expirationDate by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }

    // State for enabling the Save button
    val isSaveEnabled by derivedStateOf {
        cardNumber.isNotEmpty() && expirationDate.isNotEmpty() && cvv.isNotEmpty()
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
            text = "Add Payment Method",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp),
        )

        // Card Number Input
        OutlinedTextField(
            value = cardNumber,
            onValueChange = { cardNumber = it },
            label = { Text(text = "Card Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Expiration Date Input (MM/YY)
        OutlinedTextField(
            value = expirationDate,
            onValueChange = { expirationDate = it },
            label = { Text(text = "Expiration Date (MM/YY)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        // CVV Input
        OutlinedTextField(
            value = cvv,
            onValueChange = { cvv = it },
            label = { Text(text = "CVV") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            visualTransformation = VisualTransformation.None,  // Hide input if desired
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Save Button
        Button(
            onClick = {
                onSavePaymentMethod(cardNumber, expirationDate, cvv)
            },
            enabled = isSaveEnabled,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Save")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddPaymentMethodScreenPreview() {
    AddPaymentMethodScreen {}
}