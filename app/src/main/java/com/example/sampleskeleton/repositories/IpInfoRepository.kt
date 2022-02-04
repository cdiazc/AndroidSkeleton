package com.example.sampleskeleton.repositories

import com.example.sampleskeleton.datasources.cache.IpInfoDatasourceCache
import com.example.sampleskeleton.datasources.remote.IpInfoDatasourceRemote
import com.example.sampleskeleton.models.IpInfoLocal
import com.example.sampleskeleton.network.GenericState
import com.example.sampleskeleton.network.models.IpInfoRemote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class IpInfoRepository @Inject constructor(private val datasourceRemote: IpInfoDatasourceRemote,
                                           private val datasourceCache: IpInfoDatasourceCache) {

    private val IS_IN_CACHE = false

    suspend fun getInfo(address: String): Flow<GenericState<IpInfoLocal>> {

        return flow {

            lateinit var ipInfoRemote: IpInfoRemote

            if (IS_IN_CACHE) {
                ipInfoRemote = datasourceCache.getInfo(address)
            }
            else {
                ipInfoRemote = datasourceRemote.getInfo(address)
            }

            val ipInfoLocal = IpInfoLocal.fromRemoteToLocal(ipInfoRemote)

            //Emit this data
            emit(GenericState.success(ipInfoLocal))

        }.flowOn(Dispatchers.IO)



    }



}