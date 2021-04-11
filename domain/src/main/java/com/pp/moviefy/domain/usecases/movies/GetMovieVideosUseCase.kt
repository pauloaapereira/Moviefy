package com.pp.moviefy.domain.usecases.movies

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.Videos
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class GetMovieVideosUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<GetMovieVideosUseCase.Parameters, Videos>() {

    data class Parameters(
        val movieId: Int,
        val language: String? = null
    )

    override suspend fun execute(parameters: Parameters): Result<Videos> {
        return try {
            moviesRepository.getMovieVideos(
                parameters.movieId,
                parameters.language
            )
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}