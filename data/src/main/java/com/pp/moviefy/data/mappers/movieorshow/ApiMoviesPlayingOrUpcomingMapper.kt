package com.pp.moviefy.data.mappers.movieorshow

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.v3.movies.model.ApiMoviesPlayingOrUpcoming
import com.pp.moviefy.domain.model.MoviesPlayingOrUpcoming
import javax.inject.Inject

class ApiMoviesPlayingOrUpcomingMapper @Inject constructor(
    private val apiDatesMapper: ApiDatesMapper,
    private val apiMovieMapper: ApiMovieMapper
) : ApiMapper<ApiMoviesPlayingOrUpcoming, MoviesPlayingOrUpcoming> {
    override fun mapToDomain(obj: ApiMoviesPlayingOrUpcoming): MoviesPlayingOrUpcoming {
        return MoviesPlayingOrUpcoming(
            dates = apiDatesMapper.mapToDomain(obj.dates),
            page = obj.page ?: 0,
            results = obj.results?.map { apiMovieMapper.mapToDomain(it) }.orEmpty(),
            totalPages = obj.totalPages ?: 0,
            totalResults = obj.totalResults ?: 0,
            success = obj.success == true
        )
    }
}