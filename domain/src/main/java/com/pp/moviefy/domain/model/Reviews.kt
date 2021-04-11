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
package com.pp.moviefy.domain.model

import org.threeten.bp.LocalDateTime

data class Reviews(
    val id: Int,
    val page: Int,
    val reviews: List<Review>,
    val totalPages: Int,
    val totalResults: Int,
    val success: Boolean
)

data class Review(
    val author: String,
    val authorDetails: AuthorDetails,
    val content: String,
    val createdAt: LocalDateTime,
    val id: String,
    val updatedAt: LocalDateTime,
    val url: String
)

data class AuthorDetails(
    val avatarPath: String,
    val name: String,
    val rating: Int,
    val username: String
)
