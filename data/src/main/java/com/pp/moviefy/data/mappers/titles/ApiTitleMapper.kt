package com.pp.moviefy.data.mappers.titles

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiTitle
import com.pp.moviefy.domain.model.Title
import javax.inject.Inject

class ApiTitleMapper @Inject constructor(): ApiMapper<ApiTitle, Title> {
    override fun mapToDomain(obj: ApiTitle): Title {
        return Title(
            country = obj.country ?: "",
            title = obj.title ?: "",
            type = obj.type ?: ""
        )
    }
}