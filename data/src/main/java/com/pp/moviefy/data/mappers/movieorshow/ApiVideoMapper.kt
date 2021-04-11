package com.pp.moviefy.data.mappers.movieorshow

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiVideo
import com.pp.moviefy.domain.model.Video
import com.pp.moviefy.domain.model.VideoType
import javax.inject.Inject

class ApiVideoMapper @Inject constructor(): ApiMapper<ApiVideo, Video> {
    override fun mapToDomain(obj: ApiVideo): Video {
        return Video(
            id = obj.id ?: "",
            country = obj.country ?: "",
            language = obj.language ?: "",
            key = obj.key ?: "",
            name = obj.name ?: "",
            site = obj.site ?: "",
            size = obj.size ?: 0,
            type = VideoType.values().firstOrNull { it.id == obj.type } ?: VideoType.INVALID
        )
    }
}