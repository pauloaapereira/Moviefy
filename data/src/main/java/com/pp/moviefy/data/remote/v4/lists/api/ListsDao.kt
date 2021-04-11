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

import com.pp.moviefy.data.remote.v4.common.model.ApiList
import com.pp.moviefy.data.remote.v4.lists.model.AddListItemsBody
import com.pp.moviefy.data.remote.v4.lists.model.CreateListBody
import com.pp.moviefy.data.remote.v4.lists.model.ApiClearList
import com.pp.moviefy.data.remote.v4.lists.model.ApiCreateList
import com.pp.moviefy.data.remote.v4.lists.model.ApiDeleteList
import com.pp.moviefy.data.remote.v4.lists.model.ApiItemStatus
import com.pp.moviefy.data.remote.v4.lists.model.ApiListAddItems
import com.pp.moviefy.data.remote.v4.lists.model.ApiListRemoveItems
import com.pp.moviefy.data.remote.v4.lists.model.ApiListUpdateItems
import com.pp.moviefy.data.remote.v4.lists.model.ApiUpdateList
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
    ): ApiList

    @POST
    suspend fun createList(
        @Body body: CreateListBody
    ): ApiCreateList

    @PUT(value = "{list_id}")
    suspend fun updateList(
        @Path(value = "list_id") listId: Int,
        @Body body: UpdateListBody
    ): ApiUpdateList

    @GET(value = "{list_id}/clear")
    suspend fun clearList(
        @Path(value = "list_id") listId: Int
    ): ApiClearList

    @PUT(value = "{list_id}")
    suspend fun deleteList(
        @Path(value = "list_id") listId: Int,
    ): ApiDeleteList

    @POST(value = "{list_id}/items")
    suspend fun addListItems(
        @Path(value = "list_id") listId: Int,
        @Body body: AddListItemsBody
    ): ApiListAddItems

    @PUT(value = "{list_id}/items")
    suspend fun updateListItems(
        @Path(value = "list_id") listId: Int,
        @Body body: UpdateListItemsBody
    ): ApiListUpdateItems

    @PUT(value = "{list_id}/items")
    suspend fun removeListItems(
        @Path(value = "list_id") listId: Int,
        @Body body: RemoveListItemsBody
    ): ApiListRemoveItems

    @GET(value = "{list_id}/item_status")
    suspend fun checkItemStatus(
        @Path(value = "list_id") listId: Int,
        @Query(value = "media_id") mediaId: Int,
        @Query(value = "media_type") mediaType: String,
    ): ApiItemStatus
}
