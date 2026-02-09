package com.example.testcase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface QuotesDao {

    @Insert
    suspend fun insertQuote(quote: Quote)

    @Update
    suspend fun updateQuote(quotes: Quote)

    @Query("DELETE FROM quote")
    suspend fun delete()

    @Query("SELECT * FROM quote")
     fun getQuotes() :Flow< List<Quote> >

    @Query("SELECT * FROM quote WHERE id = :quoteId")
    suspend fun getQuoteById(quoteId: Int): Quote?
}


