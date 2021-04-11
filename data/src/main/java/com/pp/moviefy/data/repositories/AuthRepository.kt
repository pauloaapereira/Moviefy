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
package com.pp.moviefy.data.repositories

import com.pp.moviefy.data.ApiConstants
import com.pp.moviefy.data.mappers.auth.AccessTokenMapper
import com.pp.moviefy.data.mappers.auth.RequestTokenMapper
import com.pp.moviefy.data.remote.exceptions.ApiException
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
