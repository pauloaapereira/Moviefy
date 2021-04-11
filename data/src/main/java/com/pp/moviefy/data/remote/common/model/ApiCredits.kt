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

data class ApiCredits(
    @field:Json(name = "cast")
    val cast: List<ApiCast>?,
    @field:Json(name = "crew")
    val crew: List<ApiCrew>?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "status_code")
    val statusCode: Int?,
    @field:Json(name = "status_message")
    val statusMessage: String?,
    @field:Json(name = "success")
    val success: Boolean?,
    @field:Json(name = "error_message")
    val errorMessage: String?
)

data class ApiCast(
    @field:Json(name = "adult")
    val adult: Boolean?,
    @field:Json(name = "cast_id")
    val castId: Int?,
    @field:Json(name = "character")
    val character: String?,
    @field:Json(name = "credit_id")
    val creditId: String?,
    @field:Json(name = "gender")
    val gender: Int?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "known_for_department")
    val knownForDepartment: String?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "order")
    val order: Int?,
    @field:Json(name = "original_name")
    val originalName: String?,
    @field:Json(name = "popularity")
    val popularity: Double?,
    @field:Json(name = "profile_path")
    val profilePath: String?
)

data class ApiCrew(
    @field:Json(name = "adult")
    val adult: Boolean?,
    @field:Json(name = "credit_id")
    val creditId: String?,
    @field:Json(name = "department")
    val department: String?,
    @field:Json(name = "gender")
    val gender: Int?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "job")
    val job: String?,
    @field:Json(name = "known_for_department")
    val knownForDepartment: String?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "original_name")
    val originalName: String?,
    @field:Json(name = "popularity")
    val popularity: Double?,
    @field:Json(name = "profile_path")
    val profilePath: String?
)
