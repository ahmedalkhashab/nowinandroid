package com.google.samples.apps.demo.feature.store.ui.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnProceedToPayment
import com.google.samples.apps.demo.feature.store.ui.cart.component.CartItem
import com.google.samples.apps.nowinandroid.core.model.data.Product

@Composable
fun CartScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    viewModel: CartViewModel = hiltViewModel(),
    onNavigation: (StoreNavigationEvent) -> Unit
) {
    CartContent(modifier, viewModel.getCartItems(), onNavigation)
}

@Composable
internal fun CartContent(
    modifier: Modifier = Modifier,
    productsList: List<Product>,
    onNavigation: (StoreNavigationEvent) -> Unit
) {
    Column(modifier = modifier) {
        Text(
            "Your Cart",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn {
            items(productsList) { product ->
                CartItem(product)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        val total = productsList.sumOf { it.price }
        Text(
            "Total: $${String.format("%.2f", total)}",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        Button(
            onClick = { onNavigation(OnProceedToPayment) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Checkout")
        }
    }
}