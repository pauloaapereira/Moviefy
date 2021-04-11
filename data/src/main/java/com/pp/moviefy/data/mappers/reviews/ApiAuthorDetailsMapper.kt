package com.pp.moviefy.data.mappers.reviews

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiAuthorDetails
import com.pp.moviefy.domain.model.AuthorDetails
import javax.inject.Inject

class ApiAuthorDetailsMapper @Inject constructor(): ApiMapper<ApiAuthorDetails?, AuthorDetails> {
    override fun mapToDomain(obj: ApiAuthorDetails?): AuthorDetails {
        return AuthorDetails(
            avatarPath = obj?.avatarPath ?: "",
            name = obj?.name ?: "",
            rating = obj?.rating ?: 0,
            username = obj?.username ?: ""
        )
    }
}