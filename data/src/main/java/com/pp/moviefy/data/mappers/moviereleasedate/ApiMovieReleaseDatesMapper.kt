package com.pp.moviefy.data.mappers.moviereleasedate

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.v3.movies.model.ApiMovieReleaseDates
import com.pp.moviefy.domain.model.MovieReleaseDates
import javax.inject.Inject

class ApiMovieReleaseDatesMapper @Inject constructor(
    private val apiReleaseDatesByCountryMapper: ApiReleaseDatesByCountryMapper
): ApiMapper<ApiMovieReleaseDates, MovieReleaseDates> {
    override fun mapToDomain(obj: ApiMovieReleaseDates): MovieReleaseDates {
        return MovieReleaseDates(
            id = obj.id ?: 0,
            releaseDateByCountries = obj.releaseDateByCountries?.map { apiReleaseDatesByCountryMapper.mapToDomain(it) }.orEmpty(),
            success = obj.success == true
        )
    }
}