package com.pp.moviefy.domain.model

import org.threeten.bp.LocalDateTime

data class MoviesPlayingOrUpcoming(
    val dates: Dates,
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int,
    val success: Boolean
)

data class Dates(
    val maximum: LocalDateTime,
    val minimum: LocalDateTime
)
