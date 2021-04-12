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
package com.pp.moviefy.data.remote.persons.api

import com.pp.moviefy.data.remote.model.common.ApiCredits
import com.pp.moviefy.data.remote.model.common.ApiPagedResponse
import com.pp.moviefy.data.remote.model.common.ApiTranslations
import com.pp.moviefy.data.remote.persons.model.ApiPerson
import com.pp.moviefy.data.remote.persons.model.ApiPersonImages
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PersonsDao {

    @GET(value = "person/{person_id}")
    suspend fun getPersonDetails(
        @Path(value = "person_id") personId: Int,
        @Query(value = "language") language: String? = null
    ): ApiPerson

    @GET(value = "person/{person_id}/movie_credits")
    suspend fun getPersonMoviesCredits(
        @Path(value = "person_id") personId: Int,
        @Query(value = "language") language: String? = null
    ): ApiCredits

    @GET(value = "person/{person_id}/tv_credits")
    suspend fun getPersonShowsCredits(
        @Path(value = "person_id") personId: Int,
        @Query(value = "language") language: String? = null
    ): ApiCredits

    @GET(value = "person/{person_id}/images")
    suspend fun getPersonImages(
        @Path(value = "person_id") personId: Int,
    ): ApiPersonImages

    @GET(value = "person/{person_id}/translations")
    suspend fun getPersonDescriptionTranslations(
        @Path(value = "person_id") personId: Int,
        @Query(value = "language") language: String? = null
    ): ApiTranslations

    @GET(value = "person/latest")
    suspend fun getLatestAddedPerson(
        @Query(value = "language") language: String? = null
    ): ApiPerson

    @GET(value = "person/popular")
    suspend fun getPopularPersons(
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null
    ): ApiPagedResponse<ApiPerson>
}
