package com.google.samples.apps.demo.feature.store.ui.cart

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.google.samples.apps.nowinandroid.core.model.data.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    fun getCartItems(): List<Product> = listOf(
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