package com.pp.moviefy.domain.usecases.auth

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.auth.AccessToken
import com.pp.moviefy.domain.repositories.IAuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: IAuthRepository
) : BaseUseCaseWithParameters<LoginUseCase.Parameters, Unit>() {

    data class Parameters(
        val requestToken: String
    )

    override suspend fun execute(parameters: Parameters): Result<Unit> {
        val result = authRepository.login(parameters.requestToken)
        return if (result.isSuccessful()) Result.Success(Unit) else Result.Error()
    }
}