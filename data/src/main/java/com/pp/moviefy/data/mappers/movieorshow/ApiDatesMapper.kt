package com.pp.moviefy.data.mappers.movieorshow

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.v3.movies.model.ApiDates
import com.pp.moviefy.data.utils.DateTimeUtils
import com.pp.moviefy.domain.model.Dates
import javax.inject.Inject

class ApiDatesMapper @Inject constructor(): ApiMapper<ApiDates?, Dates> {
    override fun mapToDomain(obj: ApiDates?): Dates {
        return Dates(
            maximum = DateTimeUtils.parse(obj?.maximum.orEmpty()),
            minimum = DateTimeUtils.parse(obj?.minimum.orEmpty())
        )
    }
}