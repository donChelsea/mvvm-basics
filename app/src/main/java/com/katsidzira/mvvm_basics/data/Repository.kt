package com.katsidzira.mvvm_basics.data

class Repository private constructor(quoteDao: FakeQuoteDao) {

    var quoteDao = FakeQuoteDao()

    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(quoteDao: FakeQuoteDao) =
            instance ?: synchronized(this) {
                instance ?: Repository(quoteDao).also { instance = it }
            }
    }
}