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
package com.pp.moviefy.data.repositories

import com.pp.moviefy.data.exceptions.ApiException
import com.pp.moviefy.data.mappers.ApiPagedResponseMapper
import com.pp.moviefy.data.mappers.credits.ApiCreditsMapper
import com.pp.moviefy.data.mappers.images.ApiImagesMapper
import com.pp.moviefy.data.mappers.movieorshow.ApiMovieMapper
import com.pp.moviefy.data.mappers.movieorshow.ApiMoviesPlayingOrUpcomingMapper
import com.pp.moviefy.data.mappers.movieorshow.ApiVideosMapper
import com.pp.moviefy.data.mappers.moviereleasedate.ApiMovieReleaseDatesMapper
import com.pp.moviefy.data.mappers.reviews.ApiReviewsMapper
import com.pp.moviefy.data.mappers.titles.ApiTitlesMapper
import com.pp.moviefy.data.mappers.translations.ApiTranslationsMapper
import com.pp.moviefy.data.mappers.watchproviders.ApiWatchProvidersMapper
import com.pp.moviefy.data.remote.model.common.ApiMovie
import com.pp.moviefy.data.remote.model.common.RateBody
import com.pp.moviefy.data.remote.movies.api.MoviesDao
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
import com.pp.moviefy.domain.repositories.IMoviesRepository
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val moviesDao: MoviesDao,
    private val apiMovieMapper: ApiMovieMapper,
    private val apiCreditsMapper: ApiCreditsMapper,
    private val apiTitlesMapper: ApiTitlesMapper,
    private val apiImagesMapper: ApiImagesMapper,
    private val apiWatchProvidersMapper: ApiWatchProvidersMapper,
    private val apiMovieReleaseDatesMapper: ApiMovieReleaseDatesMapper,
    private val apiReviewsMapper: ApiReviewsMapper,
    private val apiTranslationsMapper: ApiTranslationsMapper,
    private val apiVideosMapper: ApiVideosMapper,
    private val apiMoviesPlayingOrUpcomingMapper: ApiMoviesPlayingOrUpcomingMapper,
    private val apiPagedResponseMapper: ApiPagedResponseMapper<ApiMovie, Movie> = ApiPagedResponseMapper(
        apiMovieMapper
    )
) : IMoviesRepository {

    override suspend fun searchMovies(
        query: String,
        language: String?,
        page: Int?,
        includeAdult: Boolean?,
        region: String?,
        year: Int?,
        primaryReleaseYear: Int?
    ): Result<PagedResponse<Movie>> {
        val result = apiPagedResponseMapper.mapToDomain(
            moviesDao.searchMovies(
                query, language, page, includeAdult, region, year, primaryReleaseYear
            )
        )

        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun getMovieDetails(movieId: Int, language: String?): Result<Movie> {
        val result = apiMovieMapper.mapToDomain(moviesDao.getMovieDetails(movieId, language))
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun getMovieCredits(movieId: Int, language: String?): Result<Credits> {
        val result = apiCreditsMapper.mapToDomain(moviesDao.getMovieCredits(movieId, language))
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun getMovieTitleTranslations(movieId: Int, country: String?): Result<Titles> {
        val result =
            apiTitlesMapper.mapToDomain(moviesDao.getMovieAlternativeTitles(movieId, country))
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun getMovieImages(
        movieId: Int,
        language: String?,
        includeImageLanguage: String?
    ): Result<Images> {
        val result = apiImagesMapper.mapToDomain(
            moviesDao.getMovieImages(
                movieId,
                language,
                includeImageLanguage
            )
        )
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun getMovieWatchProviders(movieId: Int): Result<WatchProviders> {
        val result = apiWatchProvidersMapper.mapToDomain(moviesDao.getMovieWatchProviders(movieId))
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun getMovieReleaseDates(movieId: Int): Result<MovieReleaseDates> {
        val result = apiMovieReleaseDatesMapper.mapToDomain(moviesDao.getMovieReleaseDates(movieId))
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun getMovieReviews(
        movieId: Int,
        language: String?,
        page: Int?
    ): Result<Reviews> {
        val result =
            apiReviewsMapper.mapToDomain(moviesDao.getMovieReviews(movieId, language, page))
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun getSimilarMovies(
        movieId: Int,
        language: String?,
        page: Int?
    ): Result<PagedResponse<Movie>> {
        val result =
            apiPagedResponseMapper.mapToDomain(moviesDao.getSimilarMovies(movieId, language, page))
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun getMovieDescriptionTranslations(movieId: Int): Result<Translations> {
        val result = apiTranslationsMapper.mapToDomain(moviesDao.getMovieTranslations(movieId))
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun getMovieVideos(movieId: Int, language: String?): Result<Videos> {
        val result = apiVideosMapper.mapToDomain(moviesDao.getMovieVideos(movieId, language))
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun rateMovie(movieId: Int, rating: Double): Result<Unit> {
        val result = moviesDao.rateMovie(movieId, RateBody(rating))
        return if (result.success == true) Result.Success(Unit) else Result.Error(ApiException())
    }

    override suspend fun deleteMovieRating(movieId: Int): Result<Unit> {
        val result = moviesDao.deleteMovieRating(movieId)
        return if (result.success == true) Result.Success(Unit) else Result.Error(ApiException())
    }

    override suspend fun getLatestMovieOut(language: String?): Result<Movie> {
        val result = apiMovieMapper.mapToDomain(moviesDao.getLatestMovieOut(language))
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun getMoviesNowPlaying(
        language: String?,
        page: Int?,
        region: String?
    ): Result<MoviesPlayingOrUpcoming> {
        val result = apiMoviesPlayingOrUpcomingMapper.mapToDomain(
            moviesDao.getMoviesNowPlaying(
                language,
                page,
                region
            )
        )
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun getTodayPopularMovies(
        language: String?,
        page: Int?,
        region: String?
    ): Result<PagedResponse<Movie>> {
        val result = apiPagedResponseMapper.mapToDomain(
            moviesDao.getTodayPopularMovies(
                language,
                page,
                region
            )
        )
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun getTopRatedMovies(
        language: String?,
        page: Int?,
        region: String?
    ): Result<PagedResponse<Movie>> {
        val result =
            apiPagedResponseMapper.mapToDomain(moviesDao.getTopRatedMovies(language, page, region))
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }

    override suspend fun getUpcomingMovies(
        language: String?,
        page: Int?,
        region: String?
    ): Result<MoviesPlayingOrUpcoming> {
        val result = apiMoviesPlayingOrUpcomingMapper.mapToDomain(
            moviesDao.getUpcomingMovies(
                language,
                page,
                region
            )
        )
        return if (result.success) Result.Success(result) else Result.Error(ApiException())
    }
}
