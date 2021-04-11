package com.pp.moviefy.domain.model.auth

data class AccessToken(
    val accessToken: String,
    val accountId: String,
    val success: Boolean
)
