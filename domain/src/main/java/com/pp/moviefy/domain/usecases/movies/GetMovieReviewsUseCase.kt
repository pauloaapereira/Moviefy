package com.pp.moviefy.domain.usecases.movies

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.Reviews
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class GetMovieReviewsUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<GetMovieReviewsUseCase.Parameters, Reviews>() {

    data class Parameters(
        val movieId: Int,
        val language: String? = null,
        val page: Int? = null
    )

    override suspend fun execute(parameters: Parameters): Result<Reviews> {
        return try {
            moviesRepository.getMovieReviews(
                parameters.movieId,
                parameters.language,
                parameters.page
            )
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}