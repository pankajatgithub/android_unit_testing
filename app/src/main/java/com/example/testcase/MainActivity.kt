package com.example.testcase

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testcase.adapter.ProductAdapter
import com.example.testcase.utils.NetworkResult

class MainActivity : AppCompatActivity() {


    private val quoteText: TextView
        get() = findViewById(R.id.quoteText)

    private val quoteAuthor: TextView
        get() = findViewById(R.id.quoteAuthor)


    //for MVVM
    lateinit var mainViewModel: com.example.testcase.viewModels.MainViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ProductAdapter


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.productList)
        recyclerView.layoutManager = GridLayoutManager(this,2)

        val repository = (application as StoreApplication).productRepository
        mainViewModel = ViewModelProvider(this, com.example.testcase.viewModels.MainViewModelFactory(repository)).get(com.example.testcase.viewModels.MainViewModel::class.java)
        mainViewModel.getProducts()

        mainViewModel.products.observe(this, Observer{
            when(it){
                is NetworkResult.Success -> {
                    adapter = ProductAdapter(it.data!!)
                    recyclerView.adapter = adapter
                }
                is NetworkResult.Error -> {

                }
                is NetworkResult.Loading -> {

                }

            }
        })



//        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)
//        setQuote(mainViewModel.getQuote())

    }

//    fun setQuote(quote:Quote){
//        quoteText.text = quote.text
//        quoteAuthor.text = quote.author
//    }
//
//    fun onPrevious(view: View) {
//        setQuote(mainViewModel.previousQuote())
//    }
//
//    fun onNext(view: View) {
//        setQuote(mainViewModel.nextQuote())
//    }
//
//    fun onShare(view: View) {
//        val intent = Intent(Intent.ACTION_SEND)
//        intent.setType("text/plain")
//        intent.putExtra(Intent.EXTRA_TEXT, mainViewModel.getQuote().text)
//        startActivity(intent)
//    }


}