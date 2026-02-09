package com.example.testcase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.flow.first
import org.junit.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import app.cash.turbine.test




class QuotesDaoFlowTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var quoteDatabase: QuoteDatabase
    lateinit var quotesDao: QuotesDao

    @Before
    fun setup() {
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        quotesDao = quoteDatabase.quoteDao()
    }

    @Test
    fun insertQuote_expectedSingleQuote() = runBlocking {
        val quote = Quote(0, "This is a test quote", "Test Author")

        quotesDao.insertQuote(quote)

        val result = quotesDao.getQuotes().first()

        assertEquals(1, result.size)
        assertEquals("This is a test quote", result[0].text)
    }

    @Test
    fun insertQuote_expectedDoubleQuote() = runBlocking {
        val quote = Quote(2, "This is a test quote", "Test Author")
        val quote2 = Quote(3, "This is a test quote2", "Test Author2")
        quotesDao.insertQuote(quote)
        quotesDao.insertQuote(quote2)
        val result = quotesDao.getQuotes().test{
            val quoteList = awaitItem()
            assertEquals(2, quoteList.size)
          cancel()
        }


    }



//    @Test
//    fun deleteQuote_expectedNoResults() = runBlocking {
//        val quote = Quote(0, "This is a test quote", "Test Author")
//
//        quotesDao.insertQuote(quote)
//        quotesDao.delete()
//
//        val result = quotesDao.getQuotes().getOrAwaitValue()
//        assertEquals(0, result.size)
//    }

    @After
    fun tearDown() {
        quoteDatabase.close()
    }
}