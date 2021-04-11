package com.pp.moviefy.data.mappers.translations

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiTranslations
import com.pp.moviefy.domain.model.Translations
import javax.inject.Inject

class ApiTranslationsMapper @Inject constructor(
    private val apiTranslationDataMapper: ApiTranslationDataMapper
): ApiMapper<ApiTranslations, Translations> {
    override fun mapToDomain(obj: ApiTranslations): Translations {
        return Translations(
            id = obj.id ?: 0,
            translations = obj.translations?.map { apiTranslationDataMapper.mapToDomain(it) }.orEmpty(),
            success = obj.success == true
        )
    }
}