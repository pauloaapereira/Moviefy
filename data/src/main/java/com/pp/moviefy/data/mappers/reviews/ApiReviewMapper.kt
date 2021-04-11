package com.pp.moviefy.data.mappers.reviews

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiReview
import com.pp.moviefy.data.utils.DateTimeUtils
import com.pp.moviefy.domain.model.Review
import javax.inject.Inject

class ApiReviewMapper @Inject constructor(
    private val apiAuthorDetailsMapper: ApiAuthorDetailsMapper
) : ApiMapper<ApiReview, Review> {
    override fun mapToDomain(obj: ApiReview): Review {
        return Review(
            author = obj.author ?: "",
            authorDetails = apiAuthorDetailsMapper.mapToDomain(obj.authorDetails),
            content = obj.content ?: "",
            createdAt = DateTimeUtils.parse(obj.createdAt.orEmpty()),
            id = obj.id ?: "",
            updatedAt = DateTimeUtils.parse(obj.updatedAt.orEmpty()),
            url = obj.url ?: ""
        )
    }
}