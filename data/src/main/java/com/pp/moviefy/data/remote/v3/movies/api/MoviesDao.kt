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

import com.pp.moviefy.data.remote.common.model.ApiCredits
import com.pp.moviefy.data.remote.common.model.ApiImageList
import com.pp.moviefy.data.remote.common.model.ApiMovie
import com.pp.moviefy.data.remote.common.model.ApiPagedResponse
import com.pp.moviefy.data.remote.common.model.ApiRate
import com.pp.moviefy.data.remote.common.model.ApiReviews
import com.pp.moviefy.data.remote.common.model.ApiTitles
import com.pp.moviefy.data.remote.common.model.ApiTranslations
import com.pp.moviefy.data.remote.common.model.ApiVideos
import com.pp.moviefy.data.remote.common.model.ApiWatchProviders
import com.pp.moviefy.data.remote.common.model.RateBody
import com.pp.moviefy.data.remote.v3.movies.model.ApiMovieReleaseDates
import com.pp.moviefy.data.remote.v3.movies.model.ApiMoviesPlayingOrUpcoming
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesDao {

    @GET(value = "search/movie")
    suspend fun searchMovies(
        @Query(value = "query") query: String,
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null,
        @Query(value = "include_adult") includeAdult: Boolean? = null,
        @Query(value = "region") region: String? = null,
        @Query(value = "year") year: Int? = null,
        @Query(value = "primary_release_year") primaryReleaseYear: Int? = null,
    ): ApiPagedResponse<ApiMovie>

    @GET(value = "movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "language") language: String? = null
    ): ApiMovie

    @GET(value = "movie/{movie_id}/credits")
    suspend fun getMovieCredits(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "language") language: String? = null
    ): ApiCredits

    @GET(value = "movie/{movie_id}/alternative_titles")
    suspend fun getMovieAlternativeTitles(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "country") country: String? = null
    ): ApiTitles

    @GET(value = "movie/{movie_id}/images")
    suspend fun getMovieImages(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "language") language: String? = null,
        @Query(value = "include_image_language") includeImageLanguage: String? = null
    ): ApiImageList

    // TODO: credit JustWatch for this data
    @GET(value = "movie/{movie_id}/watch/providers")
    suspend fun getMovieWatchProviders(
        @Path(value = "movie_id") movieId: Int
    ): ApiWatchProviders

    @GET(value = "movie/{movie_id}/release_dates")
    suspend fun getMovieReleaseDates(
        @Path(value = "movie_id") movieId: Int
    ): ApiMovieReleaseDates

    @GET(value = "movie/{movie_id}/reviews")
    suspend fun getMovieReviews(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null
    ): ApiReviews

    @GET(value = "movie/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null
    ): ApiPagedResponse<ApiMovie>

    @GET(value = "movie/{movie_id}/translations")
    suspend fun getMovieTranslations(
        @Path(value = "movie_id") movieId: Int
    ): ApiTranslations

    @GET(value = "movie/{movie_id}/videos")
    suspend fun getMovieVideos(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "language") language: String? = null,
    ): ApiVideos

    @POST(value = "movie/{movie_id}/rating")
    suspend fun rateMovie(
        @Path(value = "movie_id") movieId: Int,
        @Body body: RateBody
    ): ApiRate

    @DELETE(value = "movie/{movie_id}/rating")
    suspend fun deleteMovieRating(
        @Path(value = "movie_id") movieId: Int
    ): ApiRate

    @GET(value = "movie/latest")
    suspend fun getLatestMovieOut(
        @Query(value = "language") language: String? = null,
    ): ApiMovie

    @GET(value = "movie/now_playing")
    suspend fun getMoviesNowPlaying(
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null,
        @Query(value = "region") region: String? = null,
    ): ApiMoviesPlayingOrUpcoming

    @GET(value = "movie/popular")
    suspend fun getTodayPopularMovies(
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null,
        @Query(value = "region") region: String? = null,
    ): ApiPagedResponse<ApiMovie>

    @GET(value = "movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null,
        @Query(value = "region") region: String? = null,
    ): ApiPagedResponse<ApiMovie>

    @GET(value = "movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null,
        @Query(value = "region") region: String? = null,
    ): ApiMoviesPlayingOrUpcoming
}
