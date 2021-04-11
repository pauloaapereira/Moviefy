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