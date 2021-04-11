package com.pp.moviefy.domain.usecases.movies

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.Titles
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class GetMovieTitleTranslationsUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<GetMovieTitleTranslationsUseCase.Parameters, Titles>() {

    data class Parameters(
        val movieId: Int,
        val country: String? = null
    )

    override suspend fun execute(parameters: Parameters): Result<Titles> {
        return try {
            moviesRepository.getMovieTitleTranslations(parameters.movieId, parameters.country)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}