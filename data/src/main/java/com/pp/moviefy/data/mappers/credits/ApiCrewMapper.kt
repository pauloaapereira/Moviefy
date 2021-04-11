package com.pp.moviefy.data.mappers.credits

import com.pp.moviefy.data.mappers.ApiMapper
import com.pp.moviefy.data.remote.common.model.ApiCrew
import com.pp.moviefy.domain.model.Crew
import javax.inject.Inject

class ApiCrewMapper @Inject constructor(): ApiMapper<ApiCrew, Crew> {
    override fun mapToDomain(obj: ApiCrew): Crew {
        return Crew(
            adult = obj.adult ?: false,
            creditId = obj.creditId ?: "",
            department = obj.department ?: "",
            gender = obj.gender ?: 0,
            id = obj.id ?: 0,
            job = obj.job ?: "",
            knownForDepartment = obj.knownForDepartment ?: "",
            name = obj.name ?: "",
            originalName = obj.originalName ?: "",
            popularity = obj.popularity ?: 0.0,
            profilePath = obj.profilePath ?: ""
        )
    }
}
