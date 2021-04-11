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


data class ApiPerson(
    @field:Json(name = "adult")
    val adult: Boolean?,
    @field:Json(name = "also_known_as")
    val alsoKnownAs: List<String>?,
    @field:Json(name = "biography")
    val biography: String?,
    @field:Json(name = "birthday")
    val birthday: String?,
    @field:Json(name = "deathday")
    val deathday: Any?,
    @field:Json(name = "gender")
    val gender: Int?,
    @field:Json(name = "homepage")
    val homepage: Any?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "imdb_id")
    val imdbId: String?,
    @field:Json(name = "known_for_department")
    val knownForDepartment: String?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "place_of_birth")
    val placeOfBirth: String?,
    @field:Json(name = "popularity")
    val popularity: Double?,
    @field:Json(name = "profile_path")
    val profilePath: String?,
    @field:Json(name = "status_code")
    val statusCode: Int?,
    @field:Json(name = "status_message")
    val statusMessage: String?,
    @field:Json(name = "success")
    val success: Boolean?,
    @field:Json(name = "error_message")
    val errorMessage: String?
)
