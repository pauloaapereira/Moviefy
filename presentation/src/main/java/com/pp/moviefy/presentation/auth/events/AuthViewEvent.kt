package com.pp.moviefy.presentation.auth.events

sealed class AuthViewEvent {
    object RequestAuthorization : AuthViewEvent()
    data class Login(val requestToken: String): AuthViewEvent()
}
