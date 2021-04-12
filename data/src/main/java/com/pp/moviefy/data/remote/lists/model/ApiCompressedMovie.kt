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

import com.squareup.moshi.Json

data class ApiCompressedMovie(
    @field:Json(name = "media_id")
    val mediaId: Int?,
    @field:Json(name = "media_type")
    val mediaType: String?,
    @field:Json(name = "success")
    val success: Boolean?,
    @field:Json(name = "comment")
    val comment: String?
)
