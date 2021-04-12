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
package com.pp.moviefy.data.remote.account.api

import com.pp.moviefy.data.remote.lists.model.ApiList
import com.pp.moviefy.data.remote.model.common.ApiMovie
import com.pp.moviefy.data.remote.model.common.ApiPagedResponse
import com.pp.moviefy.data.remote.model.common.ApiTvShow
import retrofit2.http.GET
import retrofit2.http.Path

interface AccountDao {

    @GET(value = "{account_id}/lists")
    suspend fun getLists(
        @Path(value = "account_id") accountId: String
    ): ApiPagedResponse<ApiList>

    @GET(value = "{account_id}/movie/favorites")
    suspend fun getFavoriteMovies(
        @Path(value = "account_id") accountId: String
    ): ApiPagedResponse<ApiMovie>

    @GET(value = "{account_id}/tv/favorites")
    suspend fun getFavoriteTvShows(
        @Path(value = "account_id") accountId: String
    ): ApiPagedResponse<ApiTvShow>

    @GET(value = "{account_id}/movie/recommendations")
    suspend fun getRecommendedMovies(
        @Path(value = "account_id") accountId: String
    ): ApiPagedResponse<ApiMovie>

    @GET(value = "{account_id}/tv/recommendations")
    suspend fun getRecommendedTvShows(
        @Path(value = "account_id") accountId: String
    ): ApiPagedResponse<ApiTvShow>

    @GET(value = "{account_id}/movie/watchlist")
    suspend fun getMoviesWatchlist(
        @Path(value = "account_id") accountId: String
    ): ApiPagedResponse<ApiMovie>

    @GET(value = "{account_id}/tv/watchlist")
    suspend fun getTvShowsWatchlist(
        @Path(value = "account_id") accountId: String
    ): ApiPagedResponse<ApiTvShow>

    @GET(value = "{account_id}/movie/rated")
    suspend fun getRatedMovies(
        @Path(value = "account_id") accountId: String
    ): ApiPagedResponse<ApiMovie>

    @GET(value = "{account_id}/tv/rated")
    suspend fun getRatedTvShows(
        @Path(value = "account_id") accountId: String
    ): ApiPagedResponse<ApiTvShow>
}
