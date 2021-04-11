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

data class Images(
    val backdrops: List<Image>,
    val id: Int,
    val posters: List<Image>,
    val success: Boolean
)

data class Image(
    val aspectRatio: Double,
    val filePath: String,
    val height: Int,
    val language: String,
    val voteAverage: Double,
    val voteCount: Int,
    val width: Int
)
