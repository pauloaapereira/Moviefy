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
import com.pp.moviefy.data.remote.model.common.ApiCrew
import com.pp.moviefy.domain.model.Crew
import javax.inject.Inject

class ApiCrewMapper @Inject constructor() : ApiMapper<ApiCrew, Crew> {
    override fun mapToDomain(obj: ApiCrew): Crew {
        return Crew(
            adult = obj.adult ?: false,
            creditId = obj.creditId ?: "",
            department = obj.department ?: "",
            gender = obj.gender ?: 0,
            id = obj.id ?: 0,
            job = obj.job ?: "",
            knownForDepartment = obj.knownForDepartment ?: "",
            name = obj.name ?: "",
            originalName = obj.originalName ?: "",
            popularity = obj.popularity ?: 0.0,
            profilePath = obj.profilePath ?: ""
        )
    }
}
