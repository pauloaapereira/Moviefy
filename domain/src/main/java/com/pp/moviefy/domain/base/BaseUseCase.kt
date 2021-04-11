package com.pp.moviefy.domain.base

abstract class BaseUseCaseWithParameters<in P, R> {

    suspend operator fun invoke(parameters: P): Result<R> {
        return execute(parameters)
    }

    abstract suspend fun execute(parameters: P): Result<R>
}

abstract class BaseUseCaseWithoutParameters<R> {

    suspend operator fun invoke(): Result<R> {
        return execute()
    }

    abstract suspend fun execute(): Result<R>
}