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
package com.pp.moviefy.data.mappers.moviereleasedate

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.movies.model.ApiReleaseDatesByCountry
import com.pp.moviefy.domain.model.ReleaseDatesByCountry
import javax.inject.Inject

class ApiReleaseDatesByCountryMapper @Inject constructor(
    private val apiReleaseDateMapper: ApiReleaseDateMapper
) : ApiMapper<ApiReleaseDatesByCountry, ReleaseDatesByCountry> {
    override fun mapToDomain(obj: ApiReleaseDatesByCountry): ReleaseDatesByCountry {
        return ReleaseDatesByCountry(
            country = obj.country ?: "",
            releaseDates = obj.releaseDates?.map { apiReleaseDateMapper.mapToDomain(it) }.orEmpty()
        )
    }
}
