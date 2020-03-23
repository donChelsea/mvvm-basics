package com.katsidzira.mvvm_basics.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.katsidzira.mvvm_basics.data.Repository

class ViewModelFactory(private val quoteRepo: Repository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepo) as T
    }
}