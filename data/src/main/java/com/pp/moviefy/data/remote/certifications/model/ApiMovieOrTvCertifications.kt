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
package com.pp.moviefy.data.remote.certifications.model

import com.squareup.moshi.Json

data class ApiMovieOrTvCertifications(
    @field:Json(name = "certifications")
    val certifications: ApiMovieOrTvCertificationsByCountry?,
    @field:Json(name = "status_code")
    val statusCode: Int?,
    @field:Json(name = "status_message")
    val statusMessage: String?,
    @field:Json(name = "success")
    val success: Boolean?,
    @field:Json(name = "error_message")
    val errorMessage: String?
)

data class ApiMovieOrTvCertificationsByCountry(
    @field:Json(name = "AR")
    val aR: ApiMovieOrTvCertification?,
    @field:Json(name = "AT")
    val aT: ApiMovieOrTvCertification?,
    @field:Json(name = "AU")
    val aU: ApiMovieOrTvCertification?,
    @field:Json(name = "BE")
    val bE: ApiMovieOrTvCertification?,
    @field:Json(name = "BR")
    val bR: ApiMovieOrTvCertification?,
    @field:Json(name = "CA")
    val cA: ApiMovieOrTvCertification?,
    @field:Json(name = "CH")
    val cH: ApiMovieOrTvCertification?,
    @field:Json(name = "CL")
    val cL: ApiMovieOrTvCertification?,
    @field:Json(name = "CO")
    val cO: ApiMovieOrTvCertification?,
    @field:Json(name = "CZ")
    val cZ: ApiMovieOrTvCertification?,
    @field:Json(name = "DE")
    val dE: ApiMovieOrTvCertification?,
    @field:Json(name = "DK")
    val dK: ApiMovieOrTvCertification?,
    @field:Json(name = "EC")
    val eC: ApiMovieOrTvCertification?,
    @field:Json(name = "EE")
    val eE: ApiMovieOrTvCertification?,
    @field:Json(name = "ES")
    val eS: ApiMovieOrTvCertification?,
    @field:Json(name = "FI")
    val fI: ApiMovieOrTvCertification?,
    @field:Json(name = "FR")
    val fR: ApiMovieOrTvCertification?,
    @field:Json(name = "GB")
    val gB: ApiMovieOrTvCertification?,
    @field:Json(name = "GR")
    val gR: ApiMovieOrTvCertification?,
    @field:Json(name = "HU")
    val hU: ApiMovieOrTvCertification?,
    @field:Json(name = "ID")
    val iD: ApiMovieOrTvCertification?,
    @field:Json(name = "IE")
    val iE: ApiMovieOrTvCertification?,
    @field:Json(name = "IN")
    val iN: ApiMovieOrTvCertification?,
    @field:Json(name = "IT")
    val iT: ApiMovieOrTvCertification?,
    @field:Json(name = "JP")
    val jP: ApiMovieOrTvCertification?,
    @field:Json(name = "KR")
    val kR: ApiMovieOrTvCertification?,
    @field:Json(name = "LT")
    val lT: ApiMovieOrTvCertification?,
    @field:Json(name = "LV")
    val lV: ApiMovieOrTvCertification?,
    @field:Json(name = "MX")
    val mX: ApiMovieOrTvCertification?,
    @field:Json(name = "MY")
    val mY: ApiMovieOrTvCertification?,
    @field:Json(name = "NL")
    val nL: ApiMovieOrTvCertification?,
    @field:Json(name = "NO")
    val nO: ApiMovieOrTvCertification?,
    @field:Json(name = "NZ")
    val nZ: ApiMovieOrTvCertification?,
    @field:Json(name = "PE")
    val pE: ApiMovieOrTvCertification?,
    @field:Json(name = "PH")
    val pH: ApiMovieOrTvCertification?,
    @field:Json(name = "PL")
    val pL: ApiMovieOrTvCertification?,
    @field:Json(name = "PT")
    val pT: ApiMovieOrTvCertification?,
    @field:Json(name = "RO")
    val rO: ApiMovieOrTvCertification?,
    @field:Json(name = "RU")
    val rU: ApiMovieOrTvCertification?,
    @field:Json(name = "SE")
    val sE: ApiMovieOrTvCertification?,
    @field:Json(name = "SG")
    val sG: ApiMovieOrTvCertification?,
    @field:Json(name = "TH")
    val tH: ApiMovieOrTvCertification?,
    @field:Json(name = "TR")
    val tR: ApiMovieOrTvCertification?,
    @field:Json(name = "US")
    val uS: ApiMovieOrTvCertification?,
    @field:Json(name = "VE")
    val vE: ApiMovieOrTvCertification?,
    @field:Json(name = "ZA")
    val zA: ApiMovieOrTvCertification?
)

data class ApiMovieOrTvCertification(
    @field:Json(name = "certification")
    val certification: String?,
    @field:Json(name = "meaning")
    val meaning: String?,
    @field:Json(name = "order")
    val order: Int?
)
