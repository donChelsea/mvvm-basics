package com.katsidzira.mvvm_basics.ui

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.katsidzira.mvvm_basics.R
import com.katsidzira.mvvm_basics.data.Quote
import com.katsidzira.mvvm_basics.utlities.InjectorUtil
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: DataBindingUtil
    lateinit var viewModel: QuotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        initializeUi()

    }

    private fun initializeUi() {
        val factory = InjectorUtil.provideViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer {quotes ->
            val sb = StringBuilder()
            quotes.forEach { quote ->
                sb.append("$quote\n\n")
            }
            quotes_text.text = sb.toString()
        })

        addquote_button.setOnClickListener {
            val quote = Quote(addquote_edit.text.toString(), addauthor_edit.text.toString())
            viewModel.addQuote(quote)
            addquote_edit.setText("")
            addauthor_edit.setText("")
        }

    }
}
