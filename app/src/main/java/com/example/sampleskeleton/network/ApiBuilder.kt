package com.example.sampleskeleton.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiBuilder {

    companion object {

        var BASE_URL = "https://ipinfo.io/"

        fun create() : ApiService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)

        }
    }
}