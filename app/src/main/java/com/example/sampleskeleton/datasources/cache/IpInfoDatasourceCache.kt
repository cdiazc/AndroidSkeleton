package com.example.sampleskeleton.datasources.cache

import com.example.sampleskeleton.datasources.contracts.IpInfoDatasourceContract
import com.example.sampleskeleton.network.ApiService
import com.example.sampleskeleton.network.models.IpInfoRemote
import javax.inject.Inject

class IpInfoDatasourceCache @Inject constructor() : IpInfoDatasourceContract {

    override suspend fun getInfo(address: String): IpInfoRemote {

        //implement some caches here
        return IpInfoRemote()
    }
}