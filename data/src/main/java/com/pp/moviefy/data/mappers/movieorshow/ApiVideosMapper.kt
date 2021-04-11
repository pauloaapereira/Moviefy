package com.pp.moviefy.data.mappers.movieorshow

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiVideos
import com.pp.moviefy.domain.model.Videos
import javax.inject.Inject

class ApiVideosMapper @Inject constructor(
   private val apiVideoMapper: ApiVideoMapper
) : ApiMapper<ApiVideos, Videos> {
    override fun mapToDomain(obj: ApiVideos): Videos {
        return Videos(
            id = obj.id ?: 0,
            networkVideos = obj.networkVideos?.map { apiVideoMapper.mapToDomain(it) }.orEmpty(),
            success = obj.success == true
        )
    }
}