package com.pp.moviefy.domain.model

data class Translations(
    val id: Int,
    val translations: List<TranslationData>,
    val success: Boolean
)

data class TranslationData(
    val translation: Translation,
    val englishName: String,
    val country: String,
    val language: String,
    val name: String
)

data class Translation(
    val homepage: String,
    val overview: String,
    val title: String
)
