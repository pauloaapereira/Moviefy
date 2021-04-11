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
import com.pp.moviefy.data.remote.common.model.ApiCredits
import com.pp.moviefy.domain.model.Credits
import javax.inject.Inject

class ApiCreditsMapper @Inject constructor(
    private val apiCastMapper: ApiCastMapper,
    private val apiCrewMapper: ApiCrewMapper,
) : ApiMapper<ApiCredits, Credits> {
    override fun mapToDomain(obj: ApiCredits): Credits {
        return Credits(
            id = obj.id ?: 0,
            cast = obj.cast?.map { apiCastMapper.mapToDomain(it) }.orEmpty(),
            crew = obj.crew?.map { apiCrewMapper.mapToDomain(it) }.orEmpty(),
            success = obj.success == true
        )
    }
}
