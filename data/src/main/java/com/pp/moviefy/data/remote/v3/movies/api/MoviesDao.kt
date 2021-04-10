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

import com.pp.moviefy.data.remote.common.model.NetworkCredits
import com.pp.moviefy.data.remote.common.model.NetworkImageList
import com.pp.moviefy.data.remote.common.model.NetworkMovie
import com.pp.moviefy.data.remote.common.model.NetworkPagedResponse
import com.pp.moviefy.data.remote.common.model.NetworkRate
import com.pp.moviefy.data.remote.common.model.NetworkReviews
import com.pp.moviefy.data.remote.common.model.NetworkTitles
import com.pp.moviefy.data.remote.common.model.NetworkTranslations
import com.pp.moviefy.data.remote.common.model.NetworkVideos
import com.pp.moviefy.data.remote.common.model.NetworkWatchProviders
import com.pp.moviefy.data.remote.common.model.RateBody
import com.pp.moviefy.data.remote.v3.movies.model.NetworkMovieReleaseDates
import com.pp.moviefy.data.remote.v3.movies.model.NetworkMoviesPlayingOrUpcoming
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
    ): NetworkPagedResponse<NetworkMovie>

    @GET(value = "movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "language") language: String? = null
    ): NetworkMovie

    @GET(value = "movie/{movie_id}/credits")
    suspend fun getMovieCredits(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "language") language: String? = null
    ): NetworkCredits

    @GET(value = "movie/{movie_id}/alternative_titles")
    suspend fun getMovieAlternativeTitles(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "country") country: String? = null
    ): NetworkTitles

    @GET(value = "movie/{movie_id}/images")
    suspend fun getMovieImages(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "language") language: String? = null,
        @Query(value = "include_image_language") includeImageLanguage: String? = null
    ): NetworkImageList

    // TODO: credit JustWatch for this data
    @GET(value = "movie/{movie_id}/watch/providers")
    suspend fun getMovieWatchProviders(
        @Path(value = "movie_id") movieId: Int
    ): NetworkWatchProviders

    @GET(value = "movie/{movie_id}/release_dates")
    suspend fun getMovieReleaseDates(
        @Path(value = "movie_id") movieId: Int
    ): NetworkMovieReleaseDates

    @GET(value = "movie/{movie_id}/reviews")
    suspend fun getMovieReviews(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null
    ): NetworkReviews

    @GET(value = "movie/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null
    ): NetworkPagedResponse<NetworkMovie>

    @GET(value = "movie/{movie_id}/translations")
    suspend fun getMovieTranslations(
        @Path(value = "movie_id") movieId: Int
    ): NetworkTranslations

    @GET(value = "movie/{movie_id}/videos")
    suspend fun getMovieVideos(
        @Path(value = "movie_id") movieId: Int,
        @Query(value = "language") language: String? = null,
    ): NetworkVideos

    @POST(value = "movie/{movie_id}/rating")
    suspend fun rateMovie(
        @Path(value = "movie_id") movieId: Int,
        @Body body: RateBody
    ): NetworkRate

    @DELETE(value = "movie/{movie_id}/rating")
    suspend fun deleteMovieRating(
        @Path(value = "movie_id") movieId: Int
    ): NetworkRate

    @GET(value = "movie/latest")
    suspend fun getLatestMovieOut(
        @Query(value = "language") language: String? = null,
    ): NetworkMovie

    @GET(value = "movie/now_playing")
    suspend fun getMoviesNowPlaying(
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null,
        @Query(value = "region") region: String? = null,
    ): NetworkMoviesPlayingOrUpcoming

    @GET(value = "movie/popular")
    suspend fun getTodayPopularMovies(
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null,
        @Query(value = "region") region: String? = null,
    ): NetworkPagedResponse<NetworkMovie>

    @GET(value = "movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null,
        @Query(value = "region") region: String? = null,
    ): NetworkPagedResponse<NetworkMovie>

    @GET(value = "movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null,
        @Query(value = "region") region: String? = null,
    ): NetworkMoviesPlayingOrUpcoming
}
