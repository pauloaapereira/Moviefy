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
import com.pp.moviefy.domain.model.MoviesPlayingOrUpcoming
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class GetMovieNowPlayingUseCase @Inject constructor(
    private val moviesRepository: IMoviesRepository
) : BaseUseCaseWithParameters<GetMovieNowPlayingUseCase.Parameters, MoviesPlayingOrUpcoming>() {

    data class Parameters(
        val language: String? = null,
        val page: Int? = null,
        val region: String? = null
    )

    override suspend fun execute(parameters: Parameters): Result<MoviesPlayingOrUpcoming> {
        return try {
            moviesRepository.getMoviesNowPlaying(
                parameters.language,
                parameters.page,
                parameters.region
            )
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
