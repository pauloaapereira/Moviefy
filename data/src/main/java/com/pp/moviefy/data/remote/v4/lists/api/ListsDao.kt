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
package com.pp.moviefy.data.remote.v4.lists.api

import com.pp.moviefy.data.remote.v4.common.model.NetworkList
import com.pp.moviefy.data.remote.v4.lists.model.AddListItemsBody
import com.pp.moviefy.data.remote.v4.lists.model.CreateListBody
import com.pp.moviefy.data.remote.v4.lists.model.NetworkClearList
import com.pp.moviefy.data.remote.v4.lists.model.NetworkCreateList
import com.pp.moviefy.data.remote.v4.lists.model.NetworkDeleteList
import com.pp.moviefy.data.remote.v4.lists.model.NetworkItemStatus
import com.pp.moviefy.data.remote.v4.lists.model.NetworkListAddItems
import com.pp.moviefy.data.remote.v4.lists.model.NetworkListRemoveItems
import com.pp.moviefy.data.remote.v4.lists.model.NetworkListUpdateItems
import com.pp.moviefy.data.remote.v4.lists.model.NetworkUpdateList
import com.pp.moviefy.data.remote.v4.lists.model.RemoveListItemsBody
import com.pp.moviefy.data.remote.v4.lists.model.UpdateListBody
import com.pp.moviefy.data.remote.v4.lists.model.UpdateListItemsBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ListsDao {

    @GET(value = "{list_id}")
    suspend fun getList(
        @Path(value = "list_id") listId: Int,
        @Query(value = "page") page: Int? = null,
        @Query(value = "language") language: String? = null,
        @Query(value = "sort_by") sortBy: String? = null,
    ): NetworkList

    @POST
    suspend fun createList(
        @Body body: CreateListBody
    ): NetworkCreateList

    @PUT(value = "{list_id}")
    suspend fun updateList(
        @Path(value = "list_id") listId: Int,
        @Body body: UpdateListBody
    ): NetworkUpdateList

    @GET(value = "{list_id}/clear")
    suspend fun clearList(
        @Path(value = "list_id") listId: Int
    ): NetworkClearList

    @PUT(value = "{list_id}")
    suspend fun deleteList(
        @Path(value = "list_id") listId: Int,
    ): NetworkDeleteList

    @POST(value = "{list_id}/items")
    suspend fun addListItems(
        @Path(value = "list_id") listId: Int,
        @Body body: AddListItemsBody
    ): NetworkListAddItems

    @PUT(value = "{list_id}/items")
    suspend fun updateListItems(
        @Path(value = "list_id") listId: Int,
        @Body body: UpdateListItemsBody
    ): NetworkListUpdateItems

    @PUT(value = "{list_id}/items")
    suspend fun removeListItems(
        @Path(value = "list_id") listId: Int,
        @Body body: RemoveListItemsBody
    ): NetworkListRemoveItems

    @GET(value = "{list_id}/item_status")
    suspend fun checkItemStatus(
        @Path(value = "list_id") listId: Int,
        @Query(value = "media_id") mediaId: Int,
        @Query(value = "media_type") mediaType: String,
    ): NetworkItemStatus
}
