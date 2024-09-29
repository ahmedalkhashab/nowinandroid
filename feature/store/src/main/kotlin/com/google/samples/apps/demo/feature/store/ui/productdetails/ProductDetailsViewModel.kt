package com.google.samples.apps.demo.feature.store.ui.productdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.google.samples.apps.nowinandroid.core.model.data.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun getProduct(productId: Long?): Product? = Product(
        id = 1,
        name = "Product 1",
        description = "Description for product 1",
        price = 10.99,
        imageUrl = "https://via.placeholder.com/150",
    )
}