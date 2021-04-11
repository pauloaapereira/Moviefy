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

class GetTopRatedMoviesUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<GetTopRatedMoviesUseCase.Parameters, PagedResponse<Movie>>(dispatcher) {

    data class Parameters(
        val language: String? = null,
        val page: Int? = null,
        val region: String? = null,
    )

    override fun execute(parameters: Parameters): Flow<Result<PagedResponse<Movie>>> {
        return flow {
            emit(
                moviesRepository.getTopRatedMovies(
                    parameters.language,
                    parameters.page,
                    parameters.region
                )
            )
        }
    }
}