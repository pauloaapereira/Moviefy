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
package com.pp.moviefy.domain.usecases.auth

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.auth.RequestToken
import com.pp.moviefy.domain.repositories.IAuthRepository
import javax.inject.Inject

class RequestAuthorizationUseCase @Inject constructor(
    private val authRepository: IAuthRepository
) : BaseUseCaseWithParameters<RequestAuthorizationUseCase.Parameters, RequestToken>() {

    data class Parameters(
        val redirectTo: String? = null
    )

    override suspend fun execute(parameters: Parameters): Result<RequestToken> {
        return authRepository.requestAuthorization(parameters.redirectTo)
    }
}
