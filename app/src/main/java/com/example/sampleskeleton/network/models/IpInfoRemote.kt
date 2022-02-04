package com.example.sampleskeleton.network.models

import com.google.gson.annotations.SerializedName

data class IpInfoRemote(

    @SerializedName("city")
    var city: String = "",


    @SerializedName("region")
    var region: String = ""

)