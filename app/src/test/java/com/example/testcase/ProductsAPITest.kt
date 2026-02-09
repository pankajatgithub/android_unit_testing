package com.example.testcase

import com.example.testcase.api.ProductsAPI
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductsAPITest {
lateinit var mockWebServer : MockWebServer
lateinit var productsAPI: ProductsAPI


    @Before
    fun setup(){

        mockWebServer = MockWebServer()
        productsAPI = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ProductsAPI::class.java)
    }

    @Test
    fun testGetProducts() = runTest{
        val mockResponse = MockResponse()
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)
        val response = productsAPI.getProducts()
        mockWebServer.takeRequest()
        assert(response.body()!!.isEmpty())
    }

    @Test
    fun testGetProducts_returnProducts()= runTest {
        val mockResponse = MockResponse()
        val content = Helper.readFileResource("/response.json")
        mockResponse.setResponseCode(200)
        mockResponse.setBody(content)
        mockWebServer.enqueue(mockResponse)

        val response = productsAPI.getProducts()
        mockWebServer.takeRequest()
        assert(response.isSuccessful)
        assert(response.body()!!.isNotEmpty())
    }


    @Test
    fun testGetProducts_returnError()= runTest {
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(404)
        mockResponse.setBody("Something went wrong")
        mockWebServer.enqueue(mockResponse)

        val response = productsAPI.getProducts()
        mockWebServer.takeRequest()
        assert(!response.isSuccessful)
        assert(response.body() == null)
        assert(response.code() == 404)
        assert(response.message() == "Client Error")
        assert(response.errorBody() != null)
        assert(response.errorBody()!!.string() == "Something went wrong")

    }


    @After
    fun tearDown(){

    }
}