package com.pp.moviefy.domain.usecases.movies

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.WatchProviders
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class GetMovieWatchProviders @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<GetMovieWatchProviders.Parameters, WatchProviders>() {

    data class Parameters(
        val movieId: Int
    )

    override suspend fun execute(parameters: Parameters): Result<WatchProviders> {
        return try {
            moviesRepository.getMovieWatchProviders(
                parameters.movieId
            )
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}