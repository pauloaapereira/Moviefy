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

@JsonClass(generateAdapter = true)
data class NetworkTranslations(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "translations")
    val translations: List<TranslationData>?
)

@JsonClass(generateAdapter = true)
data class TranslationData(
    @Json(name = "data")
    val translation: Translation?,
    @Json(name = "english_name")
    val englishName: String?,
    @Json(name = "iso_3166_1")
    val country: String?,
    @Json(name = "iso_639_1")
    val language: String?,
    @Json(name = "name")
    val name: String?
)

@JsonClass(generateAdapter = true)
data class Translation(
    @Json(name = "homepage")
    val homepage: String?,
    @Json(name = "overview")
    val overview: String?,
    @Json(name = "title")
    val title: String?
)
