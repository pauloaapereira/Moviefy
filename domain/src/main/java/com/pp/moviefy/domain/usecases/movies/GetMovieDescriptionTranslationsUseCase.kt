package com.pp.moviefy.domain.usecases.movies

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.Translations
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class GetMovieDescriptionTranslationsUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<GetMovieDescriptionTranslationsUseCase.Parameters, Translations>() {

    data class Parameters(
        val movieId: Int
    )

    override suspend fun execute(parameters: Parameters): Result<Translations> {
        return try {
            moviesRepository.getMovieDescriptionTranslations(parameters.movieId)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}