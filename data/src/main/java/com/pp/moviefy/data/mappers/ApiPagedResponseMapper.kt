package com.pp.moviefy.data.mappers

import com.pp.moviefy.data.remote.common.model.ApiPagedResponse
import com.pp.moviefy.domain.model.PagedResponse
import javax.inject.Inject

class ApiPagedResponseMapper <R, T> @Inject constructor(
    private val mapper: ApiMapper<R, T>
): ApiMapper<ApiPagedResponse<R>, PagedResponse<T>> {
    override fun mapToDomain(obj: ApiPagedResponse<R>): PagedResponse<T> {
        return PagedResponse(
            page = obj.page ?: 0,
            totalPages = obj.totalPages ?: 0,
            results = obj.results?.map { mapper.mapToDomain(it) }.orEmpty(),
            totalResults = obj.totalResults ?: 0,
            success = obj.success == true
        )
    }
}