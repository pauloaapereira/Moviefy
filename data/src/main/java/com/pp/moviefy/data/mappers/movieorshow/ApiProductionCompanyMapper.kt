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
package com.pp.moviefy.data.mappers.movieorshow

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.model.common.ApiProductionCompany
import com.pp.moviefy.domain.model.ProductionCompany
import javax.inject.Inject

class ApiProductionCompanyMapper @Inject constructor() : ApiMapper<ApiProductionCompany, ProductionCompany> {
    override fun mapToDomain(obj: ApiProductionCompany): ProductionCompany {
        return ProductionCompany(
            id = obj.id ?: 0,
            logoPath = obj.logoPath ?: "",
            name = obj.name ?: "",
            originCountry = obj.originCountry ?: ""
        )
    }
}
