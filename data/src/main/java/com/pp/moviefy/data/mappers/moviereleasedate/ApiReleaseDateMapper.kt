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
import com.pp.moviefy.data.remote.v3.movies.model.ApiReleaseDate
import com.pp.moviefy.data.utils.DateTimeUtils
import com.pp.moviefy.domain.model.ReleaseDate
import com.pp.moviefy.domain.model.ReleaseDateType
import javax.inject.Inject

class ApiReleaseDateMapper @Inject constructor() : ApiMapper<ApiReleaseDate, ReleaseDate> {
    override fun mapToDomain(obj: ApiReleaseDate): ReleaseDate {
        return ReleaseDate(
            certification = obj.certification ?: "",
            language = obj.language ?: "",
            note = obj.note ?: "",
            releaseDate = DateTimeUtils.parse(obj.releaseDate.orEmpty()),
            type = ReleaseDateType.values().firstOrNull { it.id == obj.type } ?: ReleaseDateType.INVALID
        )
    }
}
