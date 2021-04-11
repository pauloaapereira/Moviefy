package com.pp.moviefy.data.mappers.watchproviders

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiWatchProvider
import com.pp.moviefy.domain.model.WatchProvider
import javax.inject.Inject

class ApiWatchProviderMapper @Inject constructor(): ApiMapper<ApiWatchProvider, WatchProvider> {
    override fun mapToDomain(obj: ApiWatchProvider): WatchProvider {
        return WatchProvider(
            displayPriority = obj.displayPriority ?: 0,
            logoPath = obj.logoPath ?: "",
            providerId = obj.providerId ?: 0,
            providerName = obj.providerName ?: ""
        )
    }
}