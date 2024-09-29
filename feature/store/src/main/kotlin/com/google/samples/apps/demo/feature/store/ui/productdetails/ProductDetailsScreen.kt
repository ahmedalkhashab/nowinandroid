package com.google.samples.apps.demo.feature.store.ui.productdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnCartClicked
import com.google.samples.apps.nowinandroid.core.model.data.Product

@Composable
fun ProductDetailsScreen(
    productId: Long?,
    modifier: Modifier = Modifier,
    viewModel: ProductDetailsViewModel = hiltViewModel(),
    onNavigation: (StoreNavigationEvent) -> Unit
) {
    val product = viewModel.getProduct(productId)
    if (product != null) ProductDetailsContent(product, modifier, onNavigation)
    else Text("Error: Product not found", style = MaterialTheme.typography.headlineLarge)
}

@Composable
internal fun ProductDetailsContent(
    product: Product,
    modifier: Modifier = Modifier,
    onNavigation: (StoreNavigationEvent) -> Unit
) {
    Column(modifier = modifier.padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(product.imageUrl),
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = product.name, style = MaterialTheme.typography.headlineLarge)
        Text(text = "$${product.price}", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = product.description)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // todo - Cart.items.add(product)
        }) {
            Text("Add to Cart")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onNavigation(OnCartClicked) }) {
            Text("Open Cart")
        }
    }
}