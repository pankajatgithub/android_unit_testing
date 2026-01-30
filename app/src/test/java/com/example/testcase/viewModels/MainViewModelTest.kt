package com.example.testcase.viewModels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.testcase.MainCoroutineRule
import com.example.testcase.getOrAwaitValue
import com.example.testcase.repository.ProductRepository
import com.example.testcase.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainCoroutineRule()

    private lateinit var repository: ProductRepository
    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        repository = Mockito.mock(ProductRepository::class.java)
        viewModel = MainViewModel(repository)
    }



    @Test
    fun test_getProducts()= runTest {
        // Given
        Mockito.`when`(repository.getProducts())
            .thenReturn(NetworkResult.Success(emptyList()))

        // When
        viewModel.getProducts()

        // 🔥 REQUIRED for StandardTestDispatcher
        mainDispatcherRule.dispatcher.scheduler.advanceUntilIdle()

        // Then
        val result = viewModel.products.getOrAwaitValue()
        Assert.assertTrue(result is NetworkResult.Success)
        Assert.assertEquals(0, result.data!!.size)

    }

}