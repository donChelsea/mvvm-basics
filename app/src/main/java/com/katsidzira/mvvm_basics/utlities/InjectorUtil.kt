package com.katsidzira.mvvm_basics.utlities

import com.katsidzira.mvvm_basics.data.FakeDatabase
import com.katsidzira.mvvm_basics.data.Repository
import com.katsidzira.mvvm_basics.ui.ViewModelFactory

object InjectorUtil {

    fun provideViewModelFactory(): ViewModelFactory {
        val quoteRepo = Repository.getInstance(FakeDatabase.getInstance().quoteDao)
        return ViewModelFactory(quoteRepo)
    }
}