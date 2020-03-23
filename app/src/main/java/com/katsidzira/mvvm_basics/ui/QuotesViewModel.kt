package com.katsidzira.mvvm_basics.ui

import androidx.lifecycle.ViewModel
import com.katsidzira.mvvm_basics.data.Quote
import com.katsidzira.mvvm_basics.data.Repository

class QuotesViewModel(private val quoteRepo: Repository): ViewModel() {

    fun getQuotes() = quoteRepo.getQuotes()

    fun addQuote(quote: Quote) = quoteRepo.addQuote(quote)
}