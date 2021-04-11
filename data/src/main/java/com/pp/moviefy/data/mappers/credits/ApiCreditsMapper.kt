package com.pp.moviefy.data.mappers.credits

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiCredits
import com.pp.moviefy.domain.model.Credits
import javax.inject.Inject

class ApiCreditsMapper @Inject constructor(
    private val apiCastMapper: ApiCastMapper,
    private val apiCrewMapper: ApiCrewMapper,
) : ApiMapper<ApiCredits, Credits> {
    override fun mapToDomain(obj: ApiCredits): Credits {
        return Credits(
            id = obj.id ?: 0,
            cast = obj.cast?.map { apiCastMapper.mapToDomain(it) }.orEmpty(),
            crew = obj.crew?.map { apiCrewMapper.mapToDomain(it) }.orEmpty(),
            success = obj.success == true
        )
    }
}