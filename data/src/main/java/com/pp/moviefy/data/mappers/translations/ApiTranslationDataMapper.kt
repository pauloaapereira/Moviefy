package com.pp.moviefy.data.mappers.translations

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiTranslationData
import com.pp.moviefy.domain.model.TranslationData
import javax.inject.Inject

class ApiTranslationDataMapper @Inject constructor(
    private val apiTranslationMapper: ApiTranslationMapper
) : ApiMapper<ApiTranslationData, TranslationData> {
    override fun mapToDomain(obj: ApiTranslationData): TranslationData {
        return TranslationData(
            translation = apiTranslationMapper.mapToDomain(obj.translation),
            englishName = obj.englishName ?: "",
            country = obj.country ?: "",
            language = obj.language ?: "",
            name = obj.name ?: ""
        )
    }
}