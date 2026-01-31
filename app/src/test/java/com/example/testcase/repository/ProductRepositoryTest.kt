package com.example.testcase.repository

import com.example.testcase.api.ProductsAPI
import com.example.testcase.models.ProductListItem
import com.example.testcase.utils.NetworkResult
import kotlinx.coroutines.test.runTest
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ProductRepositoryTest {

    @Mock
    lateinit var productsAPI : ProductsAPI



    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testGetProducts_EmptyList() = runTest {
        Mockito.`when`(productsAPI.getProducts()).thenReturn(retrofit2.Response.success(emptyList()))
        val sut = ProductRepository(productsAPI)
        val result = sut.getProducts()
        Assert.assertEquals(true,result is NetworkResult.Success)

    }

    @Test
    fun testGetProducts_expectedProductList() = runTest {
        val productList = listOf<ProductListItem>(
            ProductListItem(" ", "",1,"",40.3,"Prod1"),
            ProductListItem(" ", "",2,"",40.3,"Prod2")
        )
        Mockito.`when`(productsAPI.getProducts()).thenReturn(retrofit2.Response.success(productList))
        val sut = ProductRepository(productsAPI)
        val result = sut.getProducts()
        Assert.assertEquals(true,result is NetworkResult.Success)
        Assert.assertEquals(2,result.data!!.size)
        Assert.assertEquals("Prod1",result.data!![0].title)

    }

    @Test
    fun testGetProducts_expectedError() = runTest {
        Mockito.`when`(productsAPI.getProducts()).thenReturn(retrofit2.Response.error(401,"Unauthorized".toResponseBody()))
        val sut = ProductRepository(productsAPI)
        val result = sut.getProducts()
        Assert.assertEquals(true,result is NetworkResult.Error)
        Assert.assertEquals("Something went wrong",result.message)
    }

    @After
    fun tearDown() {
    }
}