package com.example.sampleskeleton.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.sampleskeleton.R
import com.example.sampleskeleton.databinding.ActivityMainBinding
import com.example.sampleskeleton.viewmodels.IpInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    //lateinit var viewModel: IpInfoViewModel
    val viewModel: IpInfoViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //viewModel = ViewModelProvider(this).get(IpInfoViewModel::class.java)

    }
}