package com.pp.moviefy.data.mappers.reviews

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiReviews
import com.pp.moviefy.domain.model.Reviews
import javax.inject.Inject

class ApiReviewsMapper @Inject constructor(
    private val apiReviewMapper: ApiReviewMapper
): ApiMapper<ApiReviews, Reviews> {
    override fun mapToDomain(obj: ApiReviews): Reviews {
        return Reviews(
            id = obj.id ?:0,
            page = obj.page ?: 0,
            reviews = obj.reviews?.map { apiReviewMapper.mapToDomain(it) }.orEmpty(),
            totalPages = obj.totalPages ?: 0,
            totalResults = obj.totalResults ?: 0,
            success = obj.success == true
        )
    }
}