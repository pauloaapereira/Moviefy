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

import com.pp.moviefy.domain.base.BaseUseCaseWithParameters
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class RateMovieUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<RateMovieUseCase.Parameters, Unit>() {

    data class Parameters(
        val movieId: Int,
        val rating: Double
    )

    override suspend fun execute(parameters: Parameters): Result<Unit> {
        return try {
            moviesRepository.rateMovie(
                parameters.movieId,
                parameters.rating
            )
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
