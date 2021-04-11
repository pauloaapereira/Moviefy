package com.pp.moviefy.domain.usecases.movies

import com.pp.moviefy.domain.base.FlowUseCase
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.di.IoDispatcher
import com.pp.moviefy.domain.model.Movie
import com.pp.moviefy.domain.model.PagedResponse
import com.pp.moviefy.domain.repositories.IMoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<SearchMoviesUseCase.Parameters, PagedResponse<Movie>>(dispatcher) {

    data class Parameters(
        val query: String,
        val language: String? = null,
        val page: Int? = null,
        val includeAdult: Boolean? = null,
        val region: String? = null,
        val year: Int? = null,
        val primaryReleaseYear: Int? = null,
    )

    override fun execute(parameters: Parameters): Flow<Result<PagedResponse<Movie>>> {
        return flow {
            emit(
                moviesRepository.searchMovies(
                    parameters.query,
                    parameters.language,
                    parameters.page,
                    parameters.includeAdult,
                    parameters.region,
                    parameters.year,
                    parameters.primaryReleaseYear
                )
            )
        }
    }
}