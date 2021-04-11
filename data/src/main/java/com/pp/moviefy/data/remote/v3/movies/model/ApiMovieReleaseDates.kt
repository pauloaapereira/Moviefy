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
package com.pp.moviefy.data.remote.v3.movies.model

import com.squareup.moshi.Json

data class ApiMovieReleaseDates(
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "results")
    val releaseDateByCountries: List<ApiReleaseDatesByCountry>?,
    @field:Json(name = "status_code")
    val statusCode: Int?,
    @field:Json(name = "status_message")
    val statusMessage: String?,
    @field:Json(name = "success")
    val success: Boolean?,
    @field:Json(name = "error_message")
    val errorMessage: String?
)

data class ApiReleaseDatesByCountry(
    @field:Json(name = "iso_3166_1")
    val country: String?,
    @field:Json(name = "release_dates")
    val releaseDates: List<ApiReleaseDate>?
)

data class ApiReleaseDate(
    @field:Json(name = "certification")
    val certification: String?,
    @field:Json(name = "iso_639_1")
    val language: String?,
    @field:Json(name = "note")
    val note: String?,
    @field:Json(name = "release_date")
    val releaseDate: String?,
    @field:Json(name = "type")
    val type: Int?
)
