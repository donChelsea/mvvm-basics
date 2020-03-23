package com.katsidzira.mvvm_basics.ui

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.katsidzira.mvvm_basics.R

class MainActivity : AppCompatActivity() {
    private lateinit var binding: DataBindingUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}
