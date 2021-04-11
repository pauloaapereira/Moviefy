package com.pp.moviefy.data.mappers.auth

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.v4.auth.model.ApiAccessToken
import com.pp.moviefy.domain.model.auth.AccessToken
import javax.inject.Inject

class AccessTokenMapper @Inject constructor(): ApiMapper<ApiAccessToken, AccessToken> {
    override fun mapToDomain(obj: ApiAccessToken): AccessToken {
        return AccessToken(
            accessToken = obj.accessToken ?: "",
            accountId = obj.accountId ?: "",
            success = obj.success == true
        )
    }
}