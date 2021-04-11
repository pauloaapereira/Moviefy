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
package com.pp.moviefy.domain.repositories

import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.auth.AccessToken
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
