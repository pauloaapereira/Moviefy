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
package com.pp.moviefy.data.remote.common.model

import com.squareup.moshi.Json

data class ApiMovie(
    @field:Json(name = "account_rating")
    val accountRating: ApiAccountRating?,
    @field:Json(name = "adult")
    val adult: Boolean?,
    @field:Json(name = "backdrop_path")
    val backdropPath: String?,
    @field:Json(name = "belongs_to_collection")
    val belongsToCollection: Any?,
    @field:Json(name = "budget")
    val budget: Int?,
    @field:Json(name = "genres")
    val genres: List<ApiGenre>?,
    @field:Json(name = "genre_ids")
    val genreIds: List<Int>?,
    @field:Json(name = "homepage")
    val homepage: String?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "imdb_id")
    val imdbId: String?,
    @field:Json(name = "media_type")
    val mediaType: String?,
    @field:Json(name = "original_language")
    val originalLanguage: String?,
    @field:Json(name = "original_title")
    val originalTitle: String?,
    @field:Json(name = "overview")
    val overview: String?,
    @field:Json(name = "popularity")
    val popularity: Double?,
    @field:Json(name = "poster_path")
    val posterPath: String?,
    @field:Json(name = "production_companies")
    val productionCompanies: List<ApiProductionCompany>?,
    @field:Json(name = "production_countries")
    val productionCountries: List<ApiProductionCountry>?,
    @field:Json(name = "release_date")
    val releaseDate: String?,
    @field:Json(name = "revenue")
    val revenue: Int?,
    @field:Json(name = "runtime")
    val runtime: Int?,
    @field:Json(name = "spoken_languages")
    val spokenLanguages: List<ApiSpokenLanguage>?,
    @field:Json(name = "status")
    val status: String?,
    @field:Json(name = "tagline")
    val tagline: String?,
    @field:Json(name = "title")
    val title: String?,
    @field:Json(name = "video")
    val video: Boolean?,
    @field:Json(name = "vote_average")
    val voteAverage: Double?,
    @field:Json(name = "vote_count")
    val voteCount: Int?,
    @field:Json(name = "status_code")
    val statusCode: Int?,
    @field:Json(name = "status_message")
    val statusMessage: String?,
    @field:Json(name = "success")
    val success: Boolean?,
    @field:Json(name = "error_message")
    val errorMessage: String?
)

data class ApiAccountRating(
    @field:Json(name = "created_at")
    val createdAt: String?,
    @field:Json(name = "value")
    val value: Int?
)

data class ApiGenre(
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "name")
    val name: String?
)

data class ApiProductionCompany(
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "logo_path")
    val logoPath: String?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "origin_country")
    val originCountry: String?
)

data class ApiProductionCountry(
    @field:Json(name = "iso_3166_1")
    val country: String?,
    @field:Json(name = "name")
    val name: String?
)

data class ApiSpokenLanguage(
    @field:Json(name = "english_name")
    val englishName: String?,
    @field:Json(name = "iso_639_1")
    val language: String?,
    @field:Json(name = "name")
    val name: String?
)
