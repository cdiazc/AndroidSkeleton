package com.example.sampleskeleton.usecases

import com.example.sampleskeleton.models.IpInfoLocal
import com.example.sampleskeleton.network.GenericState
import com.example.sampleskeleton.repositories.IpInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IpInfoUseCases @Inject constructor(private val ipInfoRepository: IpInfoRepository) {

    suspend fun getInfo(address: String): Flow<GenericState<IpInfoLocal>> {

        //do stuff like
        // user = otherRepo.getUserInfo(id)
        // address = user.getUserFavoriteIp(user.id)

        return ipInfoRepository.getInfo(address)
    }

}