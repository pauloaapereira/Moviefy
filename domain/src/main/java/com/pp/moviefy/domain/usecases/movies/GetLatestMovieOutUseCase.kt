package com.pp.moviefy.domain.usecases.movies

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.Movie
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class GetLatestMovieOutUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<GetLatestMovieOutUseCase.Parameters, Movie>() {

    data class Parameters(
        val language: String? = null
    )

    override suspend fun execute(parameters: Parameters): Result<Movie> {
        return try {
            moviesRepository.getLatestMovieOut(
                parameters.language,
            )
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}