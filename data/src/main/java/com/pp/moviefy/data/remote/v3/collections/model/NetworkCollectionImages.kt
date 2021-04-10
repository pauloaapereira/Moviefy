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
package com.pp.moviefy.data.remote.v3.collections.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkCollectionImages(
    @Json(name = "backdrops")
    val backdrops: List<Backdrop>?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "posters")
    val posters: List<Backdrop>?
)

@JsonClass(generateAdapter = true)
data class Backdrop(
    @Json(name = "aspect_ratio")
    val aspectRatio: Double?,
    @Json(name = "file_path")
    val filePath: String?,
    @Json(name = "height")
    val height: Int?,
    @Json(name = "iso_639_1")
    val iso6391: Any?,
    @Json(name = "vote_average")
    val voteAverage: Double?,
    @Json(name = "vote_count")
    val voteCount: Int?,
    @Json(name = "width")
    val width: Int?
)
