package com.example.sampleskeleton.datasources.contracts

import com.example.sampleskeleton.network.models.IpInfoRemote

interface IpInfoDatasourceContract {

    suspend fun getInfo(address: String): IpInfoRemote
}