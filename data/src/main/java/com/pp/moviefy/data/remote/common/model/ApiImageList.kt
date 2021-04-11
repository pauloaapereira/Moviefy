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
import com.squareup.moshi.JsonClass


data class ApiImageList(
    @field:Json(name = "backdrops")
    val backdrops: List<ApiImage>?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "posters")
    val posters: List<ApiImage>?,
    @field:Json(name = "status_code")
    val statusCode: Int?,
    @field:Json(name = "status_message")
    val statusMessage: String?,
    @field:Json(name = "success")
    val success: Boolean?,
    @field:Json(name = "error_message")
    val errorMessage: String?
)


data class ApiImage(
    @field:Json(name = "aspect_ratio")
    val aspectRatio: Double?,
    @field:Json(name = "file_path")
    val filePath: String?,
    @field:Json(name = "height")
    val height: Int?,
    @field:Json(name = "iso_639_1")
    val language: String?,
    @field:Json(name = "vote_average")
    val voteAverage: Double?,
    @field:Json(name = "vote_count")
    val voteCount: Int?,
    @field:Json(name = "width")
    val width: Int?
)
