package com.pp.moviefy.domain.usecases.movies

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.MovieReleaseDates
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class GetMovieReleaseDatesUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<GetMovieReleaseDatesUseCase.Parameters, MovieReleaseDates>() {

    data class Parameters(
        val movieId: Int
    )

    override suspend fun execute(parameters: Parameters): Result<MovieReleaseDates> {
        return try {
            moviesRepository.getMovieReleaseDates(
                parameters.movieId,
            )
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}