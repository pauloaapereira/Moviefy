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
package com.pp.moviefy.data.remote.model.common

import com.squareup.moshi.Json

data class ApiTvShow(
    @field:Json(name = "backdrop_path")
    val backdropPath: String?,
    @field:Json(name = "created_by")
    val createdBy: List<ApiTvShowCreatedBy>?,
    @field:Json(name = "episode_run_time")
    val episodeRunTime: List<Int>?,
    @field:Json(name = "first_air_date")
    val firstAirDate: String?,
    @field:Json(name = "genres")
    val genres: List<ApiGenre>?,
    @field:Json(name = "genre_ids")
    val genreIds: List<Int>?,
    @field:Json(name = "homepage")
    val homepage: String?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "in_production")
    val inProduction: Boolean?,
    @field:Json(name = "languages")
    val languages: List<String>?,
    @field:Json(name = "last_air_date")
    val lastAirDate: String?,
    @field:Json(name = "last_episode_to_air")
    val lastEpisodeToAir: ApiLastEpisodeToAir?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "networks")
    val networks: List<ApiNetwork>?,
    @field:Json(name = "next_episode_to_air")
    val nextEpisodeToAir: Any?,
    @field:Json(name = "number_of_episodes")
    val numberOfEpisodes: Int?,
    @field:Json(name = "number_of_seasons")
    val numberOfSeasons: Int?,
    @field:Json(name = "origin_country")
    val originCountry: List<String>?,
    @field:Json(name = "original_language")
    val originalLanguage: String?,
    @field:Json(name = "original_name")
    val originalName: String?,
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
    @field:Json(name = "seasons")
    val seasons: List<ApiSeason>?,
    @field:Json(name = "spoken_languages")
    val spokenLanguages: List<ApiSpokenLanguage>?,
    @field:Json(name = "status")
    val status: String?,
    @field:Json(name = "tagline")
    val tagline: String?,
    @field:Json(name = "type")
    val type: String?,
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

data class ApiTvShowCreatedBy(
    @field:Json(name = "credit_id")
    val creditId: String?,
    @field:Json(name = "gender")
    val gender: Int?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "profile_path")
    val profilePath: String?
)

data class ApiLastEpisodeToAir(
    @field:Json(name = "air_date")
    val airDate: String?,
    @field:Json(name = "episode_number")
    val episodeNumber: Int?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "overview")
    val overview: String?,
    @field:Json(name = "production_code")
    val productionCode: String?,
    @field:Json(name = "season_number")
    val seasonNumber: Int?,
    @field:Json(name = "still_path")
    val stillPath: String?,
    @field:Json(name = "vote_average")
    val voteAverage: Double?,
    @field:Json(name = "vote_count")
    val voteCount: Int?
)

data class ApiNetwork(
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "logo_path")
    val logoPath: String?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "origin_country")
    val originCountry: String?
)

data class ApiSeason(
    @field:Json(name = "air_date")
    val airDate: String?,
    @field:Json(name = "episode_count")
    val episodeCount: Int?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "overview")
    val overview: String?,
    @field:Json(name = "poster_path")
    val posterPath: String?,
    @field:Json(name = "season_number")
    val seasonNumber: Int?
)
