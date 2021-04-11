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
import com.pp.moviefy.data.remote.common.model.ApiWatchProviders
import com.pp.moviefy.domain.model.WatchProviders
import javax.inject.Inject

class ApiWatchProvidersMapper @Inject constructor(
    private val apiWatchProviderCountriesMapper: ApiWatchProviderCountriesMapper
) : ApiMapper<ApiWatchProviders, WatchProviders> {
    override fun mapToDomain(obj: ApiWatchProviders): WatchProviders {
        return WatchProviders(
            id = obj.id ?: 0,
            countries = apiWatchProviderCountriesMapper.mapToDomain(obj.countries),
            success = obj.success == true
        )
    }
}