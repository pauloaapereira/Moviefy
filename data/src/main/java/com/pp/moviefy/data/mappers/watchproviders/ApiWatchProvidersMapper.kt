package com.pp.moviefy.data.mappers.watchproviders

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiWatchProviders
import com.pp.moviefy.domain.model.WatchProviders
import javax.inject.Inject

class ApiWatchProvidersMapper @Inject constructor(
    private val apiWatchProviderCountriesMapper: ApiWatchProviderCountriesMapper
) : ApiMapper<ApiWatchProviders, WatchProviders> {
    override fun mapToDomain(obj: ApiWatchProviders): WatchProviders {
        return WatchProviders(
            id = obj.id ?: 0,
            countries = apiWatchProviderCountriesMapper.mapToDomain(obj.countries),
            success = obj.success == true
        )
    }
}