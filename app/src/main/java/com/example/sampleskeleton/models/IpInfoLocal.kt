package com.example.sampleskeleton.models

import com.example.sampleskeleton.network.models.IpInfoRemote

class IpInfoLocal {

    var city: String = ""
    var region: String = ""

    companion object {


        fun fromRemoteToLocal(remote: IpInfoRemote):IpInfoLocal {

            val local = IpInfoLocal()

            local.city = remote.city
            local.region = remote.region

            return local
        }

    }

}