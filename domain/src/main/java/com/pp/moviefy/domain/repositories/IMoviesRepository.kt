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

import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.model.Credits
import com.pp.moviefy.domain.model.Images
import com.pp.moviefy.domain.model.Movie
import com.pp.moviefy.domain.model.MovieReleaseDates
import com.pp.moviefy.domain.model.MoviesPlayingOrUpcoming
import com.pp.moviefy.domain.model.PagedResponse
import com.pp.moviefy.domain.model.Reviews
import com.pp.moviefy.domain.model.Titles
import com.pp.moviefy.domain.model.Translations
import com.pp.moviefy.domain.model.Videos
import com.pp.moviefy.domain.model.WatchProviders

interface IMoviesRepository {
    suspend fun searchMovies(
        query: String,
        language: String? = null,
        page: Int? = null,
        includeAdult: Boolean? = null,
        region: String? = null,
        year: Int? = null,
        primaryReleaseYear: Int? = null,
    ): Result<PagedResponse<Movie>>

    suspend fun getMovieDetails(
        movieId: Int,
        language: String? = null
    ): Result<Movie>

    suspend fun getMovieCredits(
        movieId: Int,
        language: String? = null
    ): Result<Credits>

    suspend fun getMovieTitleTranslations(
        movieId: Int,
        country: String? = null
    ): Result<Titles>

    suspend fun getMovieImages(
        movieId: Int,
        language: String? = null,
        includeImageLanguage: String? = null
    ): Result<Images>

    // TODO: credit JustWatch for this data
    suspend fun getMovieWatchProviders(
        movieId: Int
    ): Result<WatchProviders>

    suspend fun getMovieReleaseDates(
        movieId: Int
    ): Result<MovieReleaseDates>

    suspend fun getMovieReviews(
        movieId: Int,
        language: String? = null,
        page: Int? = null
    ): Result<Reviews>

    suspend fun getSimilarMovies(
        movieId: Int,
        language: String? = null,
        page: Int? = null
    ): Result<PagedResponse<Movie>>

    suspend fun getMovieDescriptionTranslations(
        movieId: Int
    ): Result<Translations>

    suspend fun getMovieVideos(
        movieId: Int,
        language: String? = null,
    ): Result<Videos>

    suspend fun rateMovie(
        movieId: Int,
        rating: Double
    ): Result<Unit>

    suspend fun deleteMovieRating(
        movieId: Int
    ): Result<Unit>

    suspend fun getLatestMovieOut(
        language: String? = null,
    ): Result<Movie>

    suspend fun getMoviesNowPlaying(
        language: String? = null,
        page: Int? = null,
        region: String? = null,
    ): Result<MoviesPlayingOrUpcoming>

    suspend fun getTodayPopularMovies(
        language: String? = null,
        page: Int? = null,
        region: String? = null,
    ): Result<PagedResponse<Movie>>

    suspend fun getTopRatedMovies(
        language: String? = null,
        page: Int? = null,
        region: String? = null,
    ): Result<PagedResponse<Movie>>

    suspend fun getUpcomingMovies(
        language: String? = null,
        page: Int? = null,
        region: String? = null,
    ): Result<MoviesPlayingOrUpcoming>
}
