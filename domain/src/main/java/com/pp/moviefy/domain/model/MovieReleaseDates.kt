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

import org.threeten.bp.LocalDateTime

data class MovieReleaseDates(
    val id: Int,
    val releaseDateByCountries: List<ReleaseDatesByCountry>,
    val success: Boolean
)

data class ReleaseDatesByCountry(
    val country: String,
    val releaseDates: List<ReleaseDate>
)

data class ReleaseDate(
    val certification: String,
    val language: String,
    val note: String,
    val releaseDate: LocalDateTime,
    val type: ReleaseDateType
)

enum class ReleaseDateType(val id: Int) {
    INVALID(0),
    PREMIERE(1),
    THEATRICAL_LIMITED(2),
    THEATRICAL(3),
    DIGITAL(4),
    PHYSICAL(5),
    TV(6),
}
