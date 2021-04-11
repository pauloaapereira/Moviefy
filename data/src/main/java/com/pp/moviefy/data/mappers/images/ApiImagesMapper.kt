package com.pp.moviefy.data.mappers.images

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiImageList
import com.pp.moviefy.domain.model.Images
import javax.inject.Inject

class ApiImagesMapper @Inject constructor(
    private val apiImageMapper: ApiImageMapper
): ApiMapper<ApiImageList, Images> {
    override fun mapToDomain(obj: ApiImageList): Images {
        return Images(
            id = obj.id ?: 0,
            backdrops = obj.backdrops?.map { apiImageMapper.mapToDomain(it) }.orEmpty(),
            posters = obj.posters?.map { apiImageMapper.mapToDomain(it) }.orEmpty(),
            success = obj.success == true
        )
    }
}