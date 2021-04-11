package com.pp.moviefy.domain.usecases.movies

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class DeleteMovieRatingUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<DeleteMovieRatingUseCase.Parameters, Unit>() {

    data class Parameters(
        val movieId: Int
    )

    override suspend fun execute(parameters: Parameters): Result<Unit> {
        return try {
            moviesRepository.deleteMovieRating(
                parameters.movieId
            )
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}