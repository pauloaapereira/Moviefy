package com.pp.moviefy.domain.repositories

import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.auth.AccessToken
import com.pp.moviefy.domain.model.auth.Logout
import com.pp.moviefy.domain.model.auth.RequestToken

interface IAuthRepository {

    suspend fun requestAuthorization(
        redirectTo: String? = null
    ): Result<RequestToken>

    suspend fun login(
        requestToken: String
    ): Result<AccessToken>

    suspend fun logout(): Result<Unit>

}