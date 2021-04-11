/*
 * Copyright 2021 Paulo Pereira
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
