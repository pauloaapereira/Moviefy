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
package com.pp.moviefy.data.mappers.images

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiImage
import com.pp.moviefy.domain.model.Image
import javax.inject.Inject

class ApiImageMapper @Inject constructor() : ApiMapper<ApiImage, Image> {
    override fun mapToDomain(obj: ApiImage): Image {
        return Image(
            aspectRatio = obj.aspectRatio ?: 0.0,
            filePath = obj.filePath ?: "",
            height = obj.height ?: 0,
            language = obj.language ?: "",
            voteAverage = obj.voteAverage ?: 0.0,
            voteCount = obj.voteCount ?: 0,
            width = obj.width ?: 0

        )
    }
}
