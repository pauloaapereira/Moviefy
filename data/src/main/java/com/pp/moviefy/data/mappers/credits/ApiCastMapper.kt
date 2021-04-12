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
package com.pp.moviefy.data.mappers.credits

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.model.common.ApiCast
import com.pp.moviefy.domain.model.Cast
import javax.inject.Inject

class ApiCastMapper @Inject constructor() : ApiMapper<ApiCast, Cast> {
    override fun mapToDomain(obj: ApiCast): Cast {
        return Cast(
            adult = obj.adult ?: false,
            castId = obj.castId ?: 0,
            character = obj.character ?: "",
            creditId = obj.creditId ?: "",
            gender = obj.gender ?: 0,
            id = obj.id ?: 0,
            knownForDepartment = obj.knownForDepartment ?: "",
            name = obj.name ?: "",
            order = obj.order ?: 0,
            originalName = obj.originalName ?: "",
            popularity = obj.popularity ?: 0.0,
            profilePath = obj.profilePath ?: ""
        )
    }
}
