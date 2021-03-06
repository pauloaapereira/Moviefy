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

data class ApiReviews(
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "page")
    val page: Int?,
    @field:Json(name = "results")
    val reviews: List<ApiReview>?,
    @field:Json(name = "total_pages")
    val totalPages: Int?,
    @field:Json(name = "total_results")
    val totalResults: Int?,
    @field:Json(name = "status_code")
    val statusCode: Int?,
    @field:Json(name = "status_message")
    val statusMessage: String?,
    @field:Json(name = "success")
    val success: Boolean?,
    @field:Json(name = "error_message")
    val errorMessage: String?
)

data class ApiReview(
    @field:Json(name = "author")
    val author: String?,
    @field:Json(name = "author_details")
    val authorDetails: ApiAuthorDetails?,
    @field:Json(name = "content")
    val content: String?,
    @field:Json(name = "created_at")
    val createdAt: String?,
    @field:Json(name = "id")
    val id: String?,
    @field:Json(name = "updated_at")
    val updatedAt: String?,
    @field:Json(name = "url")
    val url: String?
)

data class ApiAuthorDetails(
    @field:Json(name = "avatar_path")
    val avatarPath: String?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "rating")
    val rating: Int?,
    @field:Json(name = "username")
    val username: String?
)
