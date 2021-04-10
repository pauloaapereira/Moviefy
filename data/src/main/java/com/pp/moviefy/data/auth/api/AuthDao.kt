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
package com.pp.moviefy.data.auth.api

import com.pp.moviefy.data.auth.model.AuthorizeBody
import com.pp.moviefy.data.auth.model.LoginBody
import com.pp.moviefy.data.auth.model.LogoutBody
import com.pp.moviefy.data.auth.model.NetworkAccessToken
import com.pp.moviefy.data.auth.model.NetworkLogout
import com.pp.moviefy.data.auth.model.NetworkRequestToken
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST

interface AuthDao {

    @POST(value = "request_token")
    fun authorize(
        @Body body: AuthorizeBody
    ): NetworkRequestToken

    @POST(value = "access_token")
    fun login(
        @Body body: LoginBody
    ): NetworkAccessToken

    @DELETE(value = "access_token")
    fun logout(
        @Body body: LogoutBody
    ): NetworkLogout
}
