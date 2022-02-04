package com.example.sampleskeleton.system.di

import com.example.sampleskeleton.datasources.cache.IpInfoDatasourceCache
import com.example.sampleskeleton.datasources.remote.IpInfoDatasourceRemote
import com.example.sampleskeleton.network.ApiBuilder
import com.example.sampleskeleton.network.ApiService
import com.example.sampleskeleton.repositories.IpInfoRepository
import com.example.sampleskeleton.usecases.IpInfoUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
//https://stackoverflow.com/questions/67411219/android-hilt-cannot-be-provided-without-an-provides-annotated-method-in-reposi
//https://proandroiddev.com/all-about-hilt-a-dependency-injection-framework-869b9c2bcb09
object GenericModule {


    @Provides
    fun provideIpInfoUseCases(repository : IpInfoRepository): IpInfoUseCases {

        return IpInfoUseCases(
            repository
        )
    }

    @Provides
    fun provideIpInfoRepository(remote : IpInfoDatasourceRemote, cache : IpInfoDatasourceCache): IpInfoRepository {

        return IpInfoRepository(
            remote,
            cache
        )
    }

    @Provides
    fun provideIpInfoDatasourceRemote(): IpInfoDatasourceRemote {

        return IpInfoDatasourceRemote(ApiBuilder.create())
    }

    @Provides
    fun provideIpInfoDatasourceCache(): IpInfoDatasourceCache {

        return IpInfoDatasourceCache()
    }

    @Provides
    fun provideApiService() : ApiService {

        return ApiBuilder.create()
    }

}
