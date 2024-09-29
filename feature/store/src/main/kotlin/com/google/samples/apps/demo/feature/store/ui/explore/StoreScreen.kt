package com.google.samples.apps.demo.feature.store.ui.explore

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.samples.apps.demo.feature.store.ui.explore.component.ProductItem
import com.google.samples.apps.nowinandroid.core.model.data.Product

@Composable
fun StoreScreen(
    modifier: Modifier = Modifier,
    viewModel: StoreViewModel = hiltViewModel(),
    onNavigation: (Long) -> Unit
) {
    StoreContent(
        modifier = modifier,
        productsList = viewModel.getProductsList(),
        onNavigation = onNavigation,
    )
}

@Composable
internal fun StoreContent(
    modifier: Modifier = Modifier,
    productsList: List<Product>,
    onNavigation: (Long) -> Unit,
) {
    LazyColumn {
        items(productsList) { product ->
            ProductItem(product = product) {
                onNavigation(product.id)
            }
        }
    }
}