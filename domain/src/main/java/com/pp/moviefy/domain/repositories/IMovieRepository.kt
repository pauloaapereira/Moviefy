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
package com.pp.moviefy.domain.repositories

interface IMovieRepository {
    suspend fun searchMovies(
        query: String,
        language: String? = null,
        page: Int? = null,
        includeAdult: Boolean? = null,
        region: String? = null,
        year: Int? = null,
        primaryReleaseYear: Int? = null,
    )
/*
    suspend fun getMovieDetails(
        movieId: Int,
        language: String? = null
    ): Movie

    suspend fun getMovieCredits(
        movieId: Int,
        language: String? = null
    ): NetworkCredits

    suspend fun getMovieAlternativeTitles(
        movieId: Int,
        country: String? = null
    ): NetworkTitles

    suspend fun getMovieImages(
        movieId: Int,
        language: String? = null,
        includeImageLanguage: String? = null
    ): NetworkImageList

    // TODO: credit JustWatch for this data
    suspend fun getMovieWatchProviders(
        movieId: Int
    ): NetworkWatchProviders

    suspend fun getMovieReleaseDates(
        movieId: Int
    ): NetworkMovieReleaseDates

    suspend fun getMovieReviews(
        movieId: Int,
        language: String? = null,
        page: Int? = null
    ): NetworkReviews

    suspend fun getSimilarMovies(
        movieId: Int,
        language: String? = null,
        page: Int? = null
    ): NetworkPagedResponse<NetworkMovie>

    suspend fun getMovieTranslations(
        movieId: Int
    ): NetworkTranslations

    suspend fun getMovieVideos(
        movieId: Int,
        language: String? = null,
    ): NetworkVideos

    suspend fun rateMovie(
        movieId: Int,
        @Body body: RateBody
    ): NetworkRate

    suspend fun deleteMovieRating(
        movieId: Int
    ): NetworkRate

    suspend fun getLatestMovieOut(
        language: String? = null,
    ): NetworkMovie

    suspend fun getMoviesNowPlaying(
        language: String? = null,
        page: Int? = null,
        region: String? = null,
    ): NetworkMoviesPlayingOrUpcoming

    suspend fun getTodayPopularMovies(
        language: String? = null,
        page: Int? = null,
        region: String? = null,
    ): NetworkPagedResponse<NetworkMovie>

    suspend fun getTopRatedMovies(
        language: String? = null,
        page: Int? = null,
        region: String? = null,
    ): NetworkPagedResponse<NetworkMovie>

    suspend fun getUpcomingMovies(
        language: String? = null,
        page: Int? = null,
        region: String? = null,
    ): NetworkMoviesPlayingOrUpcoming*/
}
