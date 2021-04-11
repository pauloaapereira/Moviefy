package com.pp.moviefy.domain.usecases.movies

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class RateMovieUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<RateMovieUseCase.Parameters, Unit>() {

    data class Parameters(
        val movieId: Int,
        val rating: Double
    )

    override suspend fun execute(parameters: Parameters): Result<Unit> {
        return try {
            moviesRepository.rateMovie(
                parameters.movieId,
                parameters.rating
            )
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}