package com.pp.moviefy.data.mappers.moviereleasedate

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.v3.movies.model.ApiReleaseDate
import com.pp.moviefy.data.utils.DateTimeUtils
import com.pp.moviefy.domain.model.ReleaseDate
import com.pp.moviefy.domain.model.ReleaseDateType
import javax.inject.Inject

class ApiReleaseDateMapper @Inject constructor(): ApiMapper<ApiReleaseDate, ReleaseDate> {
    override fun mapToDomain(obj: ApiReleaseDate): ReleaseDate {
        return ReleaseDate(
            certification = obj.certification ?: "",
            language = obj.language ?: "",
            note = obj.note ?: "",
            releaseDate = DateTimeUtils.parse(obj.releaseDate.orEmpty()),
            type = ReleaseDateType.values().firstOrNull { it.id == obj.type } ?: ReleaseDateType.INVALID
        )
    }
}