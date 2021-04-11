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

data class ApiWatchProviders(
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "results")
    val countries: ApiWatchProviderCountries?,
    @field:Json(name = "status_code")
    val statusCode: Int?,
    @field:Json(name = "status_message")
    val statusMessage: String?,
    @field:Json(name = "success")
    val success: Boolean?,
    @field:Json(name = "error_message")
    val errorMessage: String?
)

data class ApiWatchProviderCountries(
    @field:Json(name = "AR")
    val aR: ApiCountryWatchProviders?,
    @field:Json(name = "AT")
    val aT: ApiCountryWatchProviders?,
    @field:Json(name = "AU")
    val aU: ApiCountryWatchProviders?,
    @field:Json(name = "BE")
    val bE: ApiCountryWatchProviders?,
    @field:Json(name = "BR")
    val bR: ApiCountryWatchProviders?,
    @field:Json(name = "CA")
    val cA: ApiCountryWatchProviders?,
    @field:Json(name = "CH")
    val cH: ApiCountryWatchProviders?,
    @field:Json(name = "CL")
    val cL: ApiCountryWatchProviders?,
    @field:Json(name = "CO")
    val cO: ApiCountryWatchProviders?,
    @field:Json(name = "CZ")
    val cZ: ApiCountryWatchProviders?,
    @field:Json(name = "DE")
    val dE: ApiCountryWatchProviders?,
    @field:Json(name = "DK")
    val dK: ApiCountryWatchProviders?,
    @field:Json(name = "EC")
    val eC: ApiCountryWatchProviders?,
    @field:Json(name = "EE")
    val eE: ApiCountryWatchProviders?,
    @field:Json(name = "ES")
    val eS: ApiCountryWatchProviders?,
    @field:Json(name = "FI")
    val fI: ApiCountryWatchProviders?,
    @field:Json(name = "FR")
    val fR: ApiCountryWatchProviders?,
    @field:Json(name = "GB")
    val gB: ApiCountryWatchProviders?,
    @field:Json(name = "GR")
    val gR: ApiCountryWatchProviders?,
    @field:Json(name = "HU")
    val hU: ApiCountryWatchProviders?,
    @field:Json(name = "ID")
    val iD: ApiCountryWatchProviders?,
    @field:Json(name = "IE")
    val iE: ApiCountryWatchProviders?,
    @field:Json(name = "IN")
    val iN: ApiCountryWatchProviders?,
    @field:Json(name = "IT")
    val iT: ApiCountryWatchProviders?,
    @field:Json(name = "JP")
    val jP: ApiCountryWatchProviders?,
    @field:Json(name = "KR")
    val kR: ApiCountryWatchProviders?,
    @field:Json(name = "LT")
    val lT: ApiCountryWatchProviders?,
    @field:Json(name = "LV")
    val lV: ApiCountryWatchProviders?,
    @field:Json(name = "MX")
    val mX: ApiCountryWatchProviders?,
    @field:Json(name = "MY")
    val mY: ApiCountryWatchProviders?,
    @field:Json(name = "NL")
    val nL: ApiCountryWatchProviders?,
    @field:Json(name = "NO")
    val nO: ApiCountryWatchProviders?,
    @field:Json(name = "NZ")
    val nZ: ApiCountryWatchProviders?,
    @field:Json(name = "PE")
    val pE: ApiCountryWatchProviders?,
    @field:Json(name = "PH")
    val pH: ApiCountryWatchProviders?,
    @field:Json(name = "PL")
    val pL: ApiCountryWatchProviders?,
    @field:Json(name = "PT")
    val pT: ApiCountryWatchProviders?,
    @field:Json(name = "RO")
    val rO: ApiCountryWatchProviders?,
    @field:Json(name = "RU")
    val rU: ApiCountryWatchProviders?,
    @field:Json(name = "SE")
    val sE: ApiCountryWatchProviders?,
    @field:Json(name = "SG")
    val sG: ApiCountryWatchProviders?,
    @field:Json(name = "TH")
    val tH: ApiCountryWatchProviders?,
    @field:Json(name = "TR")
    val tR: ApiCountryWatchProviders?,
    @field:Json(name = "US")
    val uS: ApiCountryWatchProviders?,
    @field:Json(name = "VE")
    val vE: ApiCountryWatchProviders?,
    @field:Json(name = "ZA")
    val zA: ApiCountryWatchProviders?
)

data class ApiCountryWatchProviders(
    @field:Json(name = "buy")
    val buy: List<ApiWatchProvider>?,
    @field:Json(name = "flatrate")
    val flatRate: List<ApiWatchProvider>?,
    @field:Json(name = "link")
    val link: String?,
    @field:Json(name = "rent")
    val rent: List<ApiWatchProvider>?
)

data class ApiWatchProvider(
    @field:Json(name = "display_priority")
    val displayPriority: Int?,
    @field:Json(name = "logo_path")
    val logoPath: String?,
    @field:Json(name = "provider_id")
    val providerId: Int?,
    @field:Json(name = "provider_name")
    val providerName: String?
)
