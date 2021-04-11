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
package com.pp.moviefy.data.mappers.movieorshow

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.v3.movies.model.ApiMoviesPlayingOrUpcoming
import com.pp.moviefy.domain.model.MoviesPlayingOrUpcoming
import javax.inject.Inject

class ApiMoviesPlayingOrUpcomingMapper @Inject constructor(
    private val apiDatesMapper: ApiDatesMapper,
    private val apiMovieMapper: ApiMovieMapper
) : ApiMapper<ApiMoviesPlayingOrUpcoming, MoviesPlayingOrUpcoming> {
    override fun mapToDomain(obj: ApiMoviesPlayingOrUpcoming): MoviesPlayingOrUpcoming {
        return MoviesPlayingOrUpcoming(
            dates = apiDatesMapper.mapToDomain(obj.dates),
            page = obj.page ?: 0,
            results = obj.results?.map { apiMovieMapper.mapToDomain(it) }.orEmpty(),
            totalPages = obj.totalPages ?: 0,
            totalResults = obj.totalResults ?: 0,
            success = obj.success == true
        )
    }
}
