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
package com.pp.moviefy.data.remote.v3.movies.model

import com.pp.moviefy.data.remote.common.model.ApiMovie
import com.squareup.moshi.Json

data class ApiMoviesPlayingOrUpcoming(
    @field:Json(name = "dates")
    val dates: ApiDates?,
    @field:Json(name = "page")
    val page: Int?,
    @field:Json(name = "results")
    val results: List<ApiMovie>?,
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

data class ApiDates(
    @field:Json(name = "maximum")
    val maximum: String?,
    @field:Json(name = "minimum")
    val minimum: String?
)
