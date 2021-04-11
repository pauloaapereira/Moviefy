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
package com.pp.moviefy.data.mappers.watchproviders

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiCountryWatchProviders
import com.pp.moviefy.domain.model.CountryWatchProviders
import javax.inject.Inject

class ApiCountryWatchProvidersMapper @Inject constructor(
    private val apiWatchProviderMapper: ApiWatchProviderMapper
) : ApiMapper<ApiCountryWatchProviders?, CountryWatchProviders> {
    override fun mapToDomain(obj: ApiCountryWatchProviders?): CountryWatchProviders {
        return CountryWatchProviders(
            buy = obj?.buy?.map { apiWatchProviderMapper.mapToDomain(it) }.orEmpty(),
            flatRate = obj?.flatRate?.map { apiWatchProviderMapper.mapToDomain(it) }.orEmpty(),
            link = obj?.link ?: "",
            rent = obj?.rent?.map { apiWatchProviderMapper.mapToDomain(it) }.orEmpty()
        )
    }
}
