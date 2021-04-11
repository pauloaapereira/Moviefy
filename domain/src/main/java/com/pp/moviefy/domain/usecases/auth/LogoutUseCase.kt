package com.pp.moviefy.domain.usecases.auth

import com.pp.moviefy.domain.base.BaseUseCaseWithoutParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.repositories.IAuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authRepository: IAuthRepository
) : BaseUseCaseWithoutParameters<Unit>() {

    override suspend fun execute(): Result<Unit> {
        return authRepository.logout()
    }
}