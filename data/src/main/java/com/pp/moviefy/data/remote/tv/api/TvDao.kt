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
package com.pp.moviefy.data.remote.tv.api

import com.pp.moviefy.data.remote.model.common.ApiImageList
import com.pp.moviefy.data.remote.model.common.ApiPagedResponse
import com.pp.moviefy.data.remote.model.common.ApiRate
import com.pp.moviefy.data.remote.model.common.ApiReviews
import com.pp.moviefy.data.remote.model.common.ApiTitles
import com.pp.moviefy.data.remote.model.common.ApiTranslations
import com.pp.moviefy.data.remote.model.common.ApiTvShow
import com.pp.moviefy.data.remote.model.common.ApiVideos
import com.pp.moviefy.data.remote.model.common.ApiWatchProviders
import com.pp.moviefy.data.remote.model.common.RateBody
import com.pp.moviefy.data.remote.tv.model.ApiTvContentRating
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TvDao {

    @GET(value = "search/tv")
    suspend fun searchShows(
        @Query(value = "query") query: String,
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null,
        @Query(value = "include_adult") includeAdult: Boolean? = null,
        @Query(value = "first_air_date_year") firstAirDateYear: Int? = null,
    ): ApiPagedResponse<ApiTvShow>

    @GET(value = "tv/{tv_id}")
    suspend fun getShowDetails(
        @Path(value = "tv_id") showId: Int,
        @Query(value = "language") language: String? = null
    ): ApiTvShow

    @GET(value = "tv/{tv_id}/alternative_titles")
    suspend fun getShowAlternativeTitles(
        @Path(value = "tv_id") showId: Int,
        @Query(value = "language") language: String? = null
    ): ApiTitles

    @GET(value = "tv/{tv_id}/content_ratings")
    suspend fun getShowContentRating(
        @Path(value = "tv_id") showId: Int,
        @Query(value = "language") language: String? = null
    ): ApiTvContentRating

    @GET(value = "tv/{tv_id}/credits")
    suspend fun getShowCredits(
        @Path(value = "tv_id") showId: Int,
        @Query(value = "language") language: String? = null
    ): ApiTvContentRating

    @GET(value = "tv/{tv_id}/images")
    suspend fun getShowImages(
        @Path(value = "tv_id") showId: Int,
        @Query(value = "language") language: String? = null
    ): ApiImageList

    @GET(value = "tv/{tv_id}/reviews")
    suspend fun getShowReviews(
        @Path(value = "tv_id") showId: Int,
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null,
    ): ApiReviews

    @GET(value = "tv/{tv_id}/translations")
    suspend fun getShowTranslations(
        @Path(value = "tv_id") showId: Int,
    ): ApiTranslations

    @GET(value = "tv/{tv_id}/videos")
    suspend fun getMovieVideos(
        @Path(value = "tv_id") showId: Int,
        @Query(value = "language") language: String? = null,
    ): ApiVideos

    // TODO: credit JustWatch for this data
    @GET(value = "tv/{tv_id}/watch/providers")
    suspend fun getShowWatchProviders(
        @Path(value = "tv_id") showId: Int,
    ): ApiWatchProviders

    @GET(value = "tv/{tv_id}/similar")
    suspend fun getSimilarShows(
        @Path(value = "tv_id") showId: Int,
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null
    ): ApiPagedResponse<ApiTvShow>

    @POST(value = "tv/{tv_id}/rating")
    suspend fun rateShow(
        @Path(value = "tv_id") showId: Int,
        @Body body: RateBody
    ): ApiRate

    @DELETE(value = "tv/{tv_id}/rating")
    suspend fun deleteShowRating(
        @Path(value = "tv_id") showId: Int,
    ): ApiRate

    @GET(value = "tv/latest")
    suspend fun getLatestShowOut(
        @Query(value = "language") language: String? = null,
    ): ApiTvShow

    @GET(value = "tv/on_the_air")
    suspend fun getShowsOnTheAir(
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null
    ): ApiPagedResponse<ApiTvShow>

    @GET(value = "tv/popular")
    suspend fun getTodayPopularShows(
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null
    ): ApiPagedResponse<ApiTvShow>

    @GET(value = "tv/top_rated")
    suspend fun getTopRatedShows(
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null
    ): ApiPagedResponse<ApiTvShow>
}
