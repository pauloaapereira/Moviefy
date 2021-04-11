package com.pp.moviefy.domain.model

import org.threeten.bp.LocalDateTime

data class MovieReleaseDates(
    val id: Int,
    val releaseDateByCountries: List<ReleaseDatesByCountry>,
    val success: Boolean
)

data class ReleaseDatesByCountry(
    val country: String,
    val releaseDates: List<ReleaseDate>
)

data class ReleaseDate(
    val certification: String,
    val language: String,
    val note: String,
    val releaseDate: LocalDateTime,
    val type: ReleaseDateType
)

enum class ReleaseDateType(val id: Int) {
    INVALID(0),
    PREMIERE(1),
    THEATRICAL_LIMITED(2),
    THEATRICAL(3),
    DIGITAL(4),
    PHYSICAL(5),
    TV(6),
}
