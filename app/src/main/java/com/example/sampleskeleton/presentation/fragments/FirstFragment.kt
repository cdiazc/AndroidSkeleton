package com.example.sampleskeleton.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.sampleskeleton.databinding.FragmentFirstBinding
import com.example.sampleskeleton.network.GenericStatus
import com.example.sampleskeleton.presentation.activities.MainActivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var mainActivity: MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        mainActivity = requireActivity() as MainActivity

        setDataObserver()

        setUI()

    }


    private fun setDataObserver() {

        //Since flow run asynchronously, start listening on background thread
        lifecycleScope.launch {

            // Collect the data emitted
            mainActivity.viewModel.ipInfoState.collect { state ->

                //When state to check the state of received data
                when (state.status) {

                    GenericStatus.IDLE -> {
                        binding.loading = false
                    }

                    GenericStatus.LOADING -> {
                        binding.loading = true
                    }

                    GenericStatus.SUCCESS -> {
                        binding.loading = false

                        state.data?.let { ipInfo ->

                            binding.city = ipInfo.city
                            binding.region = ipInfo.region
                        }
                    }

                    GenericStatus.ERROR -> {
                        binding.loading = false

                        binding.city = "ERROR: " + state.message
                        binding.region = "ERROR: " + state.message
                    }
                }


            }

        }

    }



    private fun setUI() {

        setButton()

    }

    private fun setButton() {

        binding.fragmentFirstButton.setOnClickListener {


            mainActivity.viewModel.getIpInfo("193.185.160.93")


        }

    }



}