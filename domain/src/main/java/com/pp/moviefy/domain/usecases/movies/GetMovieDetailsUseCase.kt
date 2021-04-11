package com.pp.moviefy.domain.usecases.movies

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.Movie
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<GetMovieDetailsUseCase.Parameters, Movie>() {

    data class Parameters(
        val movieId: Int,
        val language: String? = null
    )

    override suspend fun execute(parameters: Parameters): Result<Movie> {
        return try {
            moviesRepository.getMovieDetails(parameters.movieId, parameters.language)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}