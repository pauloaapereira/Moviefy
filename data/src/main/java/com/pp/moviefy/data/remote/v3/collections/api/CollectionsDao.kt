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
package com.pp.moviefy.data.remote.v3.collections.api

import com.pp.moviefy.data.remote.common.model.NetworkPagedResponse
import com.pp.moviefy.data.remote.v3.collections.model.NetworkCollection
import com.pp.moviefy.data.remote.v3.collections.model.NetworkCollectionImages
import com.pp.moviefy.data.remote.v3.collections.model.NetworkCollectionTranslations
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CollectionsDao {

    @GET(value = "search/collection")
    fun searchCollections(
        @Query(value = "query") query: String,
        @Query(value = "language") language: String? = null,
        @Query(value = "page") page: Int? = null
    ): NetworkPagedResponse<NetworkCollection>

    @GET(value = "collection/{collection_id}")
    fun getCollection(
        @Path(value = "collection_id") collectionId: Int,
        @Query(value = "language") language: String? = null
    ): NetworkCollection

    @GET(value = "collection/{collection_id}/images")
    fun getCollectionImages(
        @Path(value = "collection_id") collectionId: Int,
        @Query(value = "language") language: String? = null
    ): NetworkCollectionImages

    @GET(value = "collection/{collection_id}/translations")
    fun getCollectionTranslations(
        @Path(value = "collection_id") collectionId: Int,
        @Query(value = "language") language: String? = null
    ): NetworkCollectionTranslations
}
