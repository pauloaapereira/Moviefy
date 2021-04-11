package com.pp.moviefy.data.mappers.auth

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.v4.auth.model.ApiRequestToken
import com.pp.moviefy.domain.model.auth.RequestToken
import javax.inject.Inject

class RequestTokenMapper @Inject constructor(): ApiMapper<ApiRequestToken, RequestToken> {
    override fun mapToDomain(obj: ApiRequestToken): RequestToken {
        return RequestToken(
            requestToken = obj.requestToken ?: "",
            success = obj.success == true
        )
    }
}