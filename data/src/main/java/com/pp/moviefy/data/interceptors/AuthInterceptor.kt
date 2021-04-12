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
package com.pp.moviefy.data.interceptors

import com.pp.moviefy.data.ApiConstants
import com.pp.moviefy.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val accessToken = if (ApiConstants.accessToken.isNotEmpty())
            ApiConstants.accessToken
        else
            BuildConfig.TMDB_ACCESS_TOKEN

        val request = originalRequest.newBuilder()
            .url(originalRequest.url())
            .addHeader("Authorization", "Bearer $accessToken")
            .addHeader("Content-Type", "application/json;charset=utf-8")
            .build()

        return chain.proceed(request)
    }
}
