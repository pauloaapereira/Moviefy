package com.pp.moviefy.domain.model.auth

data class RequestToken(
    val requestToken: String,
    val success: Boolean
)