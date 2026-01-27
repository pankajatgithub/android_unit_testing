package com.example.testcase
import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(private val context: Context) : ViewModel() {

    private var quoteList: Array<Quote> = emptyArray()
    private var index = 0

    init {
        quoteList = loadQuoteFromAssets()
    }

    private fun loadQuoteFromAssets(): Array<Quote> {
        val inputStream = context.assets.open("quotes.json")
        val json = inputStream.bufferedReader().use { it.readText() }
        return Gson().fromJson(json, Array<Quote>::class.java)
    }

    fun getQuote(): Quote {
        return quoteList[index]
    }

    fun nextQuote(): Quote {
        index = (index + 1) % quoteList.size
        return quoteList[index]
    }

    fun previousQuote(): Quote {
        index = (index - 1 + quoteList.size) % quoteList.size
        return quoteList[index]
    }
}
