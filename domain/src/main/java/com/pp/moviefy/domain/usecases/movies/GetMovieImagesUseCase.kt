package com.pp.moviefy.domain.usecases.movies

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.Images
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class GetMovieImagesUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<GetMovieImagesUseCase.Parameters, Images>() {

    data class Parameters(
        val movieId: Int,
        val language: String? = null,
        val includeImageLanguage: String? = null
    )

    override suspend fun execute(parameters: Parameters): Result<Images> {
        return try {
            moviesRepository.getMovieImages(
                parameters.movieId,
                parameters.language,
                parameters.includeImageLanguage
            )
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}