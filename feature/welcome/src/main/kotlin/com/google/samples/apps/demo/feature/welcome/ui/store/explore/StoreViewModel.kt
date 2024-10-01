package com.google.samples.apps.demo.feature.welcome.ui.store.explore

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.google.samples.apps.nowinandroid.core.model.data.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    fun getProductsList(): List<Product> = listOf(
        Product(
            id = 1,
            name = "Product 1",
            description = "Description for product 1",
            price = 10.99,
            imageUrl = "https://via.placeholder.com/150",
        ),
        Product(
            id = 2,
            name = "Product 2",
            description = "Description for product 2",
            price = 12.99,
            imageUrl = "https://via.placeholder.com/150",
        ),
        Product(
            id = 3,
            name = "Product 3",
            description = "Description for product 3",
            price = 9.99,
            imageUrl = "https://via.placeholder.com/150",
        )
    )
}