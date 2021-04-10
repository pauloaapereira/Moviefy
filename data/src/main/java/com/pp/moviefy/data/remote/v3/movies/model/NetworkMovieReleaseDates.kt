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
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkMovieReleaseDates(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "results")
    val countryReleaseDates: List<CountryReleaseDates>?
)

@JsonClass(generateAdapter = true)
data class CountryReleaseDates(
    @Json(name = "iso_3166_1")
    val country: String?,
    @Json(name = "release_dates")
    val releaseDates: List<ReleaseDate>?
)

@JsonClass(generateAdapter = true)
data class ReleaseDate(
    @Json(name = "certification")
    val certification: String?,
    @Json(name = "iso_639_1")
    val language: String?,
    @Json(name = "note")
    val note: String?,
    @Json(name = "release_date")
    val releaseDate: String?,
    @Json(name = "type")
    val type: Int?
)

enum class ReleaseDateType(val id: Int) {
    PREMIERE(1),
    THEATRICAL_LIMITED(2),
    THEATRICAL(3),
    DIGITAL(4),
    PHYSICAL(5),
    TV(6),
}
