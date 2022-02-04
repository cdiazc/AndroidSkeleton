package com.example.sampleskeleton.network

import com.example.sampleskeleton.network.models.IpInfoRemote
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/{ip_address}/geo")
    suspend fun getCurrentWeatherData(@Path("ip_address") ipAddress: String): IpInfoRemote
}