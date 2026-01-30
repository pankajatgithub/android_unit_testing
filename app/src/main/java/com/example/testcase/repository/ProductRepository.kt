package com.example.testcase.repository

import com.example.testcase.api.ProductsAPI
import com.example.testcase.models.ProductListItem
import com.example.testcase.utils.NetworkResult

class ProductRepository (private val productsAPI: ProductsAPI) {

    suspend fun getProducts(): NetworkResult<List<ProductListItem>> {
        val response = productsAPI.getProducts()
        return if (response.isSuccessful && response.body() != null) {
            NetworkResult.Success(response.body()!!)
            } else {
            NetworkResult.Error("Something went wrong")
        }


    }

}