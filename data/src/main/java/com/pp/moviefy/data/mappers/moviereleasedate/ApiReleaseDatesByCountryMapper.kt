package com.pp.moviefy.data.mappers.moviereleasedate

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.v3.movies.model.ApiReleaseDatesByCountry
import com.pp.moviefy.domain.model.ReleaseDatesByCountry
import javax.inject.Inject

class ApiReleaseDatesByCountryMapper @Inject constructor(
    private val apiReleaseDateMapper: ApiReleaseDateMapper
) : ApiMapper<ApiReleaseDatesByCountry, ReleaseDatesByCountry> {
    override fun mapToDomain(obj: ApiReleaseDatesByCountry): ReleaseDatesByCountry {
        return ReleaseDatesByCountry(
            country = obj.country ?: "",
            releaseDates = obj.releaseDates?.map { apiReleaseDateMapper.mapToDomain(it) }.orEmpty()
        )
    }
}