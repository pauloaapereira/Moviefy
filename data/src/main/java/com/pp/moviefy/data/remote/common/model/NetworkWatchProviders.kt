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
data class NetworkWatchProviders(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "results")
    val watchProvidersByCountry: WatchProvidersByCountry?
)

@JsonClass(generateAdapter = true)
data class WatchProvidersByCountry(
    @Json(name = "AR")
    val aR: CountryWatchProviders?,
    @Json(name = "AT")
    val aT: CountryWatchProviders?,
    @Json(name = "AU")
    val aU: CountryWatchProviders?,
    @Json(name = "BE")
    val bE: CountryWatchProviders?,
    @Json(name = "BR")
    val bR: CountryWatchProviders?,
    @Json(name = "CA")
    val cA: CountryWatchProviders?,
    @Json(name = "CH")
    val cH: CountryWatchProviders?,
    @Json(name = "CL")
    val cL: CountryWatchProviders?,
    @Json(name = "CO")
    val cO: CountryWatchProviders?,
    @Json(name = "CZ")
    val cZ: CountryWatchProviders?,
    @Json(name = "DE")
    val dE: CountryWatchProviders?,
    @Json(name = "DK")
    val dK: CountryWatchProviders?,
    @Json(name = "EC")
    val eC: CountryWatchProviders?,
    @Json(name = "EE")
    val eE: CountryWatchProviders?,
    @Json(name = "ES")
    val eS: CountryWatchProviders?,
    @Json(name = "FI")
    val fI: CountryWatchProviders?,
    @Json(name = "FR")
    val fR: CountryWatchProviders?,
    @Json(name = "GB")
    val gB: CountryWatchProviders?,
    @Json(name = "GR")
    val gR: CountryWatchProviders?,
    @Json(name = "HU")
    val hU: CountryWatchProviders?,
    @Json(name = "ID")
    val iD: CountryWatchProviders?,
    @Json(name = "IE")
    val iE: CountryWatchProviders?,
    @Json(name = "IN")
    val iN: CountryWatchProviders?,
    @Json(name = "IT")
    val iT: CountryWatchProviders?,
    @Json(name = "JP")
    val jP: CountryWatchProviders?,
    @Json(name = "KR")
    val kR: CountryWatchProviders?,
    @Json(name = "LT")
    val lT: CountryWatchProviders?,
    @Json(name = "LV")
    val lV: CountryWatchProviders?,
    @Json(name = "MX")
    val mX: CountryWatchProviders?,
    @Json(name = "MY")
    val mY: CountryWatchProviders?,
    @Json(name = "NL")
    val nL: CountryWatchProviders?,
    @Json(name = "NO")
    val nO: CountryWatchProviders?,
    @Json(name = "NZ")
    val nZ: CountryWatchProviders?,
    @Json(name = "PE")
    val pE: CountryWatchProviders?,
    @Json(name = "PH")
    val pH: CountryWatchProviders?,
    @Json(name = "PL")
    val pL: CountryWatchProviders?,
    @Json(name = "PT")
    val pT: CountryWatchProviders?,
    @Json(name = "RO")
    val rO: CountryWatchProviders?,
    @Json(name = "RU")
    val rU: CountryWatchProviders?,
    @Json(name = "SE")
    val sE: CountryWatchProviders?,
    @Json(name = "SG")
    val sG: CountryWatchProviders?,
    @Json(name = "TH")
    val tH: CountryWatchProviders?,
    @Json(name = "TR")
    val tR: CountryWatchProviders?,
    @Json(name = "US")
    val uS: CountryWatchProviders?,
    @Json(name = "VE")
    val vE: CountryWatchProviders?,
    @Json(name = "ZA")
    val zA: CountryWatchProviders?
)

@JsonClass(generateAdapter = true)
data class CountryWatchProviders(
    @Json(name = "buy")
    val buy: List<WatchProviders>?,
    @Json(name = "flatrate")
    val flatrate: List<WatchProviders>?,
    @Json(name = "link")
    val link: String?,
    @Json(name = "rent")
    val rent: List<WatchProviders>?
)

@JsonClass(generateAdapter = true)
data class WatchProviders(
    @Json(name = "display_priority")
    val displayPriority: Int?,
    @Json(name = "logo_path")
    val logoPath: String?,
    @Json(name = "provider_id")
    val providerId: Int?,
    @Json(name = "provider_name")
    val providerName: String?
)
