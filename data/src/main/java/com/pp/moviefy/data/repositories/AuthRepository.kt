package com.pp.moviefy.data.repositories

import com.pp.moviefy.data.ApiConstants
import com.pp.moviefy.data.remote.exceptions.ApiException
import com.pp.moviefy.data.mappers.auth.AccessTokenMapper
import com.pp.moviefy.data.mappers.auth.RequestTokenMapper
import com.pp.moviefy.data.remote.v4.auth.api.AuthDao
import com.pp.moviefy.data.remote.v4.auth.model.AuthorizeBody
import com.pp.moviefy.data.remote.v4.auth.model.LoginBody
import com.pp.moviefy.data.remote.v4.auth.model.LogoutBody
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.auth.AccessToken
import com.pp.moviefy.domain.model.auth.RequestToken
import com.pp.moviefy.domain.repositories.IAuthRepository
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val requestTokenMapper: RequestTokenMapper,
    private val accessTokenMapper: AccessTokenMapper,
    private val authDao: AuthDao
) : IAuthRepository {

    override suspend fun requestAuthorization(redirectTo: String?): Result<RequestToken> {
        val result = requestTokenMapper.mapToDomain(authDao.requestAuthorization(AuthorizeBody(redirectTo)))
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun login(requestToken: String): Result<AccessToken> {
        val result = accessTokenMapper.mapToDomain(authDao.login(LoginBody(requestToken)))
        return if (result.success) {
            ApiConstants.accessToken = result.accessToken
            Result.Success(result)
        } else {
            Result.Error(ApiException())
        }
    }

    override suspend fun logout(): Result<Unit> {
        val result = authDao.logout(LogoutBody(ApiConstants.accessToken))
        return if (result.success == true) Result.Success(Unit) else Result.Error(ApiException())
    }
}