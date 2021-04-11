package com.pp.moviefy.data.mappers.titles

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiTitles
import com.pp.moviefy.domain.model.Titles
import javax.inject.Inject

class ApiTitlesMapper @Inject constructor(
    private val apiTitleMapper: ApiTitleMapper
) : ApiMapper<ApiTitles, Titles> {
    override fun mapToDomain(obj: ApiTitles): Titles {
        return Titles(
            id = obj.id ?: 0,
            titles = obj.titles?.map { apiTitleMapper.mapToDomain(it) }.orEmpty(),
            success = obj.success == true
        )
    }
}