package com.pp.moviefy.data.mappers.translations

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiTranslation
import com.pp.moviefy.domain.model.Translation
import javax.inject.Inject

class ApiTranslationMapper @Inject constructor(): ApiMapper<ApiTranslation?, Translation> {
    override fun mapToDomain(obj: ApiTranslation?): Translation {
        return Translation(
            homepage = obj?.homepage ?: "",
            overview = obj?.overview ?: "",
            title = obj?.title ?: ""
        )
    }
}