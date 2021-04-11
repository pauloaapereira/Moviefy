package com.pp.moviefy.data.mappers.credits

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiCast
import com.pp.moviefy.domain.model.Cast
import javax.inject.Inject

class ApiCastMapper @Inject constructor(): ApiMapper<ApiCast, Cast> {
    override fun mapToDomain(obj: ApiCast): Cast {
        return Cast(
            adult = obj.adult ?: false,
            castId = obj.castId ?: 0,
            character = obj.character ?: "",
            creditId = obj.creditId ?: "",
            gender = obj.gender ?: 0,
            id = obj.id ?: 0,
            knownForDepartment = obj.knownForDepartment ?: "",
            name = obj.name ?: "",
            order = obj.order ?: 0,
            originalName = obj.originalName ?: "",
            popularity = obj.popularity ?: 0.0,
            profilePath = obj.profilePath ?: ""
        )
    }
}
