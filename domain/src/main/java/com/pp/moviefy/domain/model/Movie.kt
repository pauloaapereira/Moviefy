/*
 * Copyright 2021 Paulo Pereira
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pp.moviefy.domain.model

import org.threeten.bp.LocalDateTime

data class Movie(
    val accountRating: AccountRating,
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: Any? = null,
    val budget: Int,
    val genres: List<Genre>,
    val genreIds: List<Int>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val mediaType: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountry>,
    val releaseDate: LocalDateTime,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    val success: Boolean
)

data class AccountRating(
    val createdAt: String,
    val value: Int
) {

    fun isValid() = createdAt.isNotEmpty()
}

data class Genre(
    val id: Int,
    val name: String
)

data class ProductionCompany(
    val id: Int,
    val logoPath: String,
    val name: String,
    val originCountry: String
) {

    fun isValid() = name.isNotEmpty()
}

data class ProductionCountry(
    val country: String,
    val name: String
)

data class SpokenLanguage(
    val englishName: String,
    val language: String,
    val name: String
) {

    fun isValid() = language.isNotEmpty()
}
