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
package com.pp.moviefy.data.remote.v3.persons.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkPerson(
    @Json(name = "adult")
    val adult: Boolean?,
    @Json(name = "also_known_as")
    val alsoKnownAs: List<String>?,
    @Json(name = "biography")
    val biography: String?,
    @Json(name = "birthday")
    val birthday: String?,
    @Json(name = "deathday")
    val deathday: Any?,
    @Json(name = "gender")
    val gender: Int?,
    @Json(name = "homepage")
    val homepage: Any?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "imdb_id")
    val imdbId: String?,
    @Json(name = "known_for_department")
    val knownForDepartment: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "place_of_birth")
    val placeOfBirth: String?,
    @Json(name = "popularity")
    val popularity: Double?,
    @Json(name = "profile_path")
    val profilePath: String?
)
