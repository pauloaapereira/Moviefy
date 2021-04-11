package com.pp.moviefy.domain.usecases.movies

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.Credits
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class GetMovieCreditsUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<GetMovieCreditsUseCase.Parameters, Credits>() {

    data class Parameters(
        val movieId: Int,
        val language: String? = null
    )

    override suspend fun execute(parameters: Parameters): Result<Credits> {
        return try {
            moviesRepository.getMovieCredits(parameters.movieId, parameters.language)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}