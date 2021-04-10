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
package com.pp.moviefy.data.remote.v3.movies.api

import com.pp.moviefy.data.remote.common.model.NetworkMovie
import com.pp.moviefy.data.remote.common.model.NetworkPagedResponse
import com.pp.moviefy.data.remote.v3.movies.model.NetworkMovieCredits
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesDao {

    @GET(value = "search/movie")
    fun searchMovies(
        @Query(value = "query") query: String,
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null,
        @Query(value = "include_adult") includeAdult: Boolean? = null,
        @Query(value = "region") region: String? = null,
        @Query(value = "year") year: Int? = null,
        @Query(value = "primary_release_year") primary_release_year: Int? = null,
    ): NetworkPagedResponse<NetworkMovie>

    @GET(value = "movie/{movie_id}")
    fun getMovieDetails(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "language") language: String? = null
    ): NetworkMovie

    @GET(value = "movie/{movie_id}/credits")
    fun getMovieCredits(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "language") language: String? = null
    ): NetworkMovieCredits
}
