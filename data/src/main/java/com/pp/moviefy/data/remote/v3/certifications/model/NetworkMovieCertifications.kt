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
package com.pp.moviefy.data.remote.v3.certifications.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkMovieOrTvCertifications(
    @Json(name = "certifications")
    val certifications: MovieOrTvCertifications?
)

@JsonClass(generateAdapter = true)
data class MovieOrTvCertifications(
    @Json(name = "AU")
    val aU: List<MovieOrTvCertification>?,
    @Json(name = "BG")
    val bG: List<MovieOrTvCertification>?,
    @Json(name = "BR")
    val bR: List<MovieOrTvCertification>?,
    @Json(name = "CA")
    val cA: List<MovieOrTvCertification>?,
    @Json(name = "DE")
    val dE: List<MovieOrTvCertification>?,
    @Json(name = "ES")
    val eS: List<MovieOrTvCertification>?,
    @Json(name = "FI")
    val fI: List<MovieOrTvCertification>?,
    @Json(name = "FR")
    val fR: List<MovieOrTvCertification>?,
    @Json(name = "GB")
    val gB: List<MovieOrTvCertification>?,
    @Json(name = "IN")
    val iN: List<MovieOrTvCertification>?,
    @Json(name = "NL")
    val nL: List<MovieOrTvCertification>?,
    @Json(name = "NZ")
    val nZ: List<MovieOrTvCertification>?,
    @Json(name = "PH")
    val pH: List<MovieOrTvCertification>?,
    @Json(name = "PT")
    val pT: List<MovieOrTvCertification>?,
    @Json(name = "US")
    val uS: List<MovieOrTvCertification>?
)

@JsonClass(generateAdapter = true)
data class MovieOrTvCertification(
    @Json(name = "certification")
    val certification: String?,
    @Json(name = "meaning")
    val meaning: String?,
    @Json(name = "order")
    val order: Int?
)
