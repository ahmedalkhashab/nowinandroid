package com.google.samples.apps.demo.feature.store.ui.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnCartClicked
import com.google.samples.apps.demo.feature.store.StoreNavigationEvent.OnProductItemClicked
import com.google.samples.apps.demo.feature.store.ui.explore.component.ProductItem
import com.google.samples.apps.nowinandroid.core.model.data.Product

@Composable
fun StoreScreen(
    modifier: Modifier = Modifier,
    viewModel: StoreViewModel = hiltViewModel(),
    onNavigation: (StoreNavigationEvent) -> Unit
) {
    StoreContent(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        productsList = viewModel.getProductsList(),
        onNavigation = onNavigation,
    )
}

@Composable
internal fun StoreContent(
    modifier: Modifier = Modifier,
    productsList: List<Product>,
    onNavigation: (StoreNavigationEvent) -> Unit,
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = { onNavigation(OnCartClicked) }) {
                Text("My Cart")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(productsList) { product ->
                ProductItem(product = product) {
                    onNavigation(OnProductItemClicked(product.id))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StoreScreenPreview() {
    StoreScreen(onNavigation = {})
}