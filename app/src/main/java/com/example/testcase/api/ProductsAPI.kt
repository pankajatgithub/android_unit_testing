package com.example.testcase.api

import com.example.testcase.models.ProductListItem
import com.example.testcase.utils.NetworkResult
import retrofit2.Response
import retrofit2.http.GET

interface ProductsAPI {
    @GET("/products")
    suspend fun getProducts(): Response<List<ProductListItem>>
}