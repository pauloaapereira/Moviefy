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
package com.pp.moviefy.data.remote.lists.model

import com.pp.moviefy.data.remote.model.common.ApiMovie
import com.squareup.moshi.Json

data class ApiList(
    @field:Json(name = "adult")
    val adult: Int?,
    @field:Json(name = "average_rating")
    val averageRating: Double?,
    @field:Json(name = "backdrop_path")
    val backdropPath: String?,
    @field:Json(name = "comments")
    val comments: Any?,
    @field:Json(name = "created_at")
    val createdAt: String?,
    @field:Json(name = "created_by")
    val createdBy: ApiListCreatedBy?,
    @field:Json(name = "description")
    val description: String?,
    @field:Json(name = "featured")
    val featured: Int?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "iso_3166_1")
    val country: String?,
    @field:Json(name = "iso_639_1")
    val language: String?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "number_of_items")
    val numberOfItems: Int?,
    @field:Json(name = "object_ids")
    val objectIds: Any?,
    @field:Json(name = "page")
    val page: Int?,
    @field:Json(name = "poster_path")
    val posterPath: String?,
    @field:Json(name = "public")
    val isPublic: Int?,
    @field:Json(name = "results")
    val results: List<ApiMovie>?,
    @field:Json(name = "revenue")
    val revenue: String?,
    @field:Json(name = "runtime")
    val runtime: Int?,
    @field:Json(name = "sort_by")
    val sortBy: Int?,
    @field:Json(name = "updated_at")
    val updatedAt: String?,
    @field:Json(name = "status_code")
    val statusCode: Int?,
    @field:Json(name = "status_message")
    val statusMessage: String?,
    @field:Json(name = "success")
    val success: Boolean?,
    @field:Json(name = "error_message")
    val errorMessage: String?
)

data class ApiListCreatedBy(
    @field:Json(name = "gravatar_hash")
    val gravatarHash: String?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "username")
    val username: String?
)
