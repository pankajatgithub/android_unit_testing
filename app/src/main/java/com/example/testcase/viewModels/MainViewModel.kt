package com.example.testcase.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testcase.models.ProductListItem
import com.example.testcase.repository.ProductRepository
import com.example.testcase.utils.NetworkResult
import kotlinx.coroutines.launch

class MainViewModel (private val repository: ProductRepository) : ViewModel(){

private val _products = MutableLiveData<NetworkResult<List<ProductListItem>>>()
    val products: MutableLiveData<NetworkResult<List<ProductListItem>>>
    get() = _products

     fun getProducts() {
         viewModelScope.launch {
             val response = repository.getProducts()
             _products.postValue(response)
         }
    }




}