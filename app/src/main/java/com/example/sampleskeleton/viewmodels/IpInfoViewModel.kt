package com.example.sampleskeleton.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleskeleton.models.IpInfoLocal
import com.example.sampleskeleton.network.GenericState
import com.example.sampleskeleton.network.GenericStatus
import com.example.sampleskeleton.usecases.IpInfoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

//@ViewModelInject is deprecated
@HiltViewModel
class IpInfoViewModel @Inject constructor(private val ipInfoUseCases : IpInfoUseCases): ViewModel() {

    val ipInfoState = MutableStateFlow(
        GenericState(GenericStatus.IDLE, IpInfoLocal())
    )

    fun getIpInfo(address: String) {

        ipInfoState.value = GenericState.loading()

        viewModelScope.launch {

            ipInfoUseCases.getInfo(address)

                //40X catching
                .catch { exception ->
                    ipInfoState.value = GenericState.error(exception.message.toString())
                }

                //state is what the repo/use case emitted
                .collect { state ->
                    ipInfoState.value = GenericState.success(state.data)
                }
        }


    }



}