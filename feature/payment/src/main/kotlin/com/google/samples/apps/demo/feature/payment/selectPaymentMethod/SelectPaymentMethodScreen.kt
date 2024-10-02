package com.google.samples.apps.demo.feature.payment.selectPaymentMethod

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.semantics.Role
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.samples.apps.demo.feature.payment.PaymentNavigationEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SelectPaymentMethodScreen(
    viewModel: SelectPaymentMethodViewModel = hiltViewModel(),
    onNavigation: (PaymentNavigationEvent) -> Unit
) {
    val scope = rememberCoroutineScope() // Initialize the scope
    val context = LocalContext.current
    SelectPaymentMethodContent(
        onConfirmPaymentClick = {
            viewModel.confirmPayment { method ->
                scope.launch {
                    Toast.makeText(context, "Payment Success", Toast.LENGTH_SHORT).show()
                    delay(1500)
                    onNavigation(PaymentNavigationEvent.OnPaymentCompleted(method))
                }
            }
        },
        onNavigation = onNavigation,
    )
}

@Composable
private fun SelectPaymentMethodContent(
    onConfirmPaymentClick: (String) -> Unit,
    onNavigation: (PaymentNavigationEvent) -> Unit
) {
    val availablePaymentMethods: List<String> =
        listOf("Credit Card", "PayPal", "Google Pay", "Apple Pay")

    // State to hold the currently selected payment method
    var selectedPaymentMethod by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 56.dp)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            text = "Select Payment Method",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp),
        )

        // Display a list of payment methods using LazyColumn
        LazyColumn {
            items(availablePaymentMethods.size) { index ->
                val paymentMethod = availablePaymentMethods[index]
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (paymentMethod == selectedPaymentMethod),
                            onClick = {
                                selectedPaymentMethod = paymentMethod
                            },
                            role = Role.RadioButton,
                        )
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    RadioButton(
                        selected = (paymentMethod == selectedPaymentMethod),
                        onClick = null, // Handled by Row's onClick
                    )
                    Text(
                        text = paymentMethod,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 8.dp),
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("You have to pay your receipt with 2350 rayal")
        Spacer(modifier = Modifier.height(24.dp))

        // Confirm Button, enabled only when a payment method is selected
        Button(
            onClick = { selectedPaymentMethod?.let { onConfirmPaymentClick(it) } },
            enabled = selectedPaymentMethod != null,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Confirm")
        }
        Button(
            onClick = { onNavigation(PaymentNavigationEvent.OnAddPaymentMethodClick) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Add Payment Method")
        }

        Button(
            onClick = { onNavigation(PaymentNavigationEvent.OnPayWithMadaClick("TransactionId")) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Pay with Mada")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectPaymentMethodScreenPreview() {
    SelectPaymentMethodScreen{}
}
