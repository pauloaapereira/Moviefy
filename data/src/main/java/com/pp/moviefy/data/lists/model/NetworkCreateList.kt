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
package com.pp.moviefy.data.lists.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkCreateList(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "status_code")
    val statusCode: Int?,
    @Json(name = "status_message")
    val statusMessage: String?,
    @Json(name = "success")
    val success: Boolean?,
    @Json(name = "error_message")
    val errorMessage: String?,
)

data class CreateListBody(
    @Json(name = "name")
    val name: String,
    @Json(name = "iso_639_1")
    val lang: String,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "public")
    val isPublic: Boolean? = null
)