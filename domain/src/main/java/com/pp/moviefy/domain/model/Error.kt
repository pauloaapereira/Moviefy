package com.pp.moviefy.domain.model

data class Error(
    val statusCode: Int,
    val statusMessage: String,
    val success: Boolean,
    val errorMessage: String
)