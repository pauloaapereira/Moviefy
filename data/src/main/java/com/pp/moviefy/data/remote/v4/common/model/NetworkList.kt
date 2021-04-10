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
package com.pp.moviefy.data.remote.v4.common.model

import com.pp.moviefy.data.remote.common.model.NetworkMovie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkList(
    @Json(name = "adult")
    val adult: Int?,
    @Json(name = "average_rating")
    val averageRating: Double?,
    @Json(name = "backdrop_path")
    val backdropPath: String?,
    @Json(name = "comments")
    val comments: Any?,
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "created_by")
    val createdBy: CreatedBy?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "featured")
    val featured: Int?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "iso_3166_1")
    val country: String?,
    @Json(name = "iso_639_1")
    val language: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "number_of_items")
    val numberOfItems: Int?,
    @Json(name = "object_ids")
    val objectIds: Any?,
    @Json(name = "page")
    val page: Int?,
    @Json(name = "poster_path")
    val posterPath: String?,
    @Json(name = "public")
    val isPublic: Int?,
    @Json(name = "results")
    val results: List<NetworkMovie>?,
    @Json(name = "revenue")
    val revenue: String?,
    @Json(name = "runtime")
    val runtime: Int?,
    @Json(name = "sort_by")
    val sortBy: Int?,
    @Json(name = "updated_at")
    val updatedAt: String?
)

@JsonClass(generateAdapter = true)
data class CreatedBy(
    @Json(name = "gravatar_hash")
    val gravatarHash: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "username")
    val username: String?
)
