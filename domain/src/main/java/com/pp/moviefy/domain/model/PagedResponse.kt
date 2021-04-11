package com.pp.moviefy.domain.model

data class PagedResponse <T>(
    val page: Int,
    val totalPages: Int,
    val results: List<T>,
    val totalResults: Int,
    val success: Boolean
)
