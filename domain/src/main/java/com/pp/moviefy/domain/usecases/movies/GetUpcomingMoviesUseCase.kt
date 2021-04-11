package com.pp.moviefy.domain.usecases.movies

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.MoviesPlayingOrUpcoming
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class GetUpcomingMoviesUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<GetUpcomingMoviesUseCase.Parameters, MoviesPlayingOrUpcoming>() {

    data class Parameters(
        val language: String? = null,
        val page: Int? = null,
        val region: String? = null
    )

    override suspend fun execute(parameters: Parameters): Result<MoviesPlayingOrUpcoming> {
        return try {
            moviesRepository.getUpcomingMovies(
                parameters.language,
                parameters.page,
                parameters.region
            )
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}