package com.pp.moviefy.presentation.auth.state

import com.pp.moviefy.presentation.auth.state.AuthViewStatus.IDLE

data class AuthViewState(
    val requestToken: String = "",
    val viewStatus: AuthViewStatus = IDLE
)

enum class AuthViewStatus {
    IDLE,
    ERROR,
    LOADING,
    REQUESTING_AUTHORIZATION,
    LOGGED_IN
}