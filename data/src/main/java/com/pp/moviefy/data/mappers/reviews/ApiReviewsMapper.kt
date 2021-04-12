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
package com.pp.moviefy.data.mappers.reviews

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.model.common.ApiReviews
import com.pp.moviefy.domain.model.Reviews
import javax.inject.Inject

class ApiReviewsMapper @Inject constructor(
    private val apiReviewMapper: ApiReviewMapper
) : ApiMapper<ApiReviews, Reviews> {
    override fun mapToDomain(obj: ApiReviews): Reviews {
        return Reviews(
            id = obj.id ?: 0,
            page = obj.page ?: 0,
            reviews = obj.reviews?.map { apiReviewMapper.mapToDomain(it) }.orEmpty(),
            totalPages = obj.totalPages ?: 0,
            totalResults = obj.totalResults ?: 0,
            success = obj.success == true
        )
    }
}
