package com.pp.moviefy.data.mappers.images

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiImage
import com.pp.moviefy.domain.model.Image
import javax.inject.Inject

class ApiImageMapper @Inject constructor(): ApiMapper<ApiImage, Image> {
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