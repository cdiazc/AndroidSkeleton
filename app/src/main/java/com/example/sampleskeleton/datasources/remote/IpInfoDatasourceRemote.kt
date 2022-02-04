package com.example.sampleskeleton.datasources.remote

import com.example.sampleskeleton.datasources.contracts.IpInfoDatasourceContract
import com.example.sampleskeleton.network.ApiService
import com.example.sampleskeleton.network.models.IpInfoRemote
import javax.inject.Inject


class IpInfoDatasourceRemote @Inject constructor(private val service: ApiService) : IpInfoDatasourceContract {

    override suspend fun getInfo(address: String): IpInfoRemote {

        return service.getCurrentWeatherData("193.185.160.93")
    }
}