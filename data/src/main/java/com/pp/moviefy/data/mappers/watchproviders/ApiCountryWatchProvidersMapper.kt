package com.pp.moviefy.data.mappers.watchproviders

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiCountryWatchProviders
import com.pp.moviefy.domain.model.CountryWatchProviders
import javax.inject.Inject

class ApiCountryWatchProvidersMapper @Inject constructor(
    private val apiWatchProviderMapper: ApiWatchProviderMapper
) : ApiMapper<ApiCountryWatchProviders?, CountryWatchProviders> {
    override fun mapToDomain(obj: ApiCountryWatchProviders?): CountryWatchProviders {
        return CountryWatchProviders(
            buy = obj?.buy?.map { apiWatchProviderMapper.mapToDomain(it) }.orEmpty(),
            flatRate = obj?.flatRate?.map { apiWatchProviderMapper.mapToDomain(it) }.orEmpty(),
            link = obj?.link ?: "",
            rent = obj?.rent?.map { apiWatchProviderMapper.mapToDomain(it) }.orEmpty()
        )
    }
}