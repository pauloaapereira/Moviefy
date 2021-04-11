/*
 * Copyright 2021 Paulo Pereira
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pp.moviefy.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pp.moviefy.domain.base.Result
import com.pp.moviefy.domain.usecases.auth.LoginUseCase
import com.pp.moviefy.domain.usecases.auth.RequestAuthorizationUseCase
import com.pp.moviefy.presentation.auth.events.AuthViewEvent
import com.pp.moviefy.presentation.auth.state.AuthViewState
import com.pp.moviefy.presentation.auth.state.AuthViewStatus.ERROR
import com.pp.moviefy.presentation.auth.state.AuthViewStatus.IDLE
import com.pp.moviefy.presentation.auth.state.AuthViewStatus.LOADING
import com.pp.moviefy.presentation.auth.state.AuthViewStatus.LOGGED_IN
import com.pp.moviefy.presentation.auth.state.AuthViewStatus.REQUESTING_AUTHORIZATION
import com.pp.moviefy.presentation.utils.AUTHORIZED_REDIRECTION
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.pp.moviefy.domain.usecases.auth.RequestAuthorizationUseCase.Parameters as RequestAuthorizationParameters

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val login: LoginUseCase,
    private val requestAuthorization: RequestAuthorizationUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(AuthViewState())
    val state = _state.asStateFlow()

    fun onEvent(event: AuthViewEvent) = viewModelScope.launch {
        when (event) {
            AuthViewEvent.RequestAuthorization -> {
                _state.emit(state.value.copy(viewStatus = LOADING))

                when (val result = requestAuthorization(RequestAuthorizationParameters(redirectTo = AUTHORIZED_REDIRECTION))) {
                    is Result.Success -> {
                        _state.emit(
                            state.value.copy(
                                viewStatus = REQUESTING_AUTHORIZATION,
                                requestToken = result.data.requestToken
                            )
                        )
                    }
                    else -> showError()
                }
            }
            is AuthViewEvent.Login -> {
                _state.emit(state.value.copy(viewStatus = LOADING))

                when (login(LoginUseCase.Parameters(requestToken = event.requestToken))) {
                    is Result.Success -> {
                        _state.emit(state.value.copy(viewStatus = LOGGED_IN))
                    }
                    else -> showError()
                }
            }
        }
    }

    private fun showError() = viewModelScope.launch {
        _state.emit(state.value.copy(viewStatus = ERROR))
        delay(2500L)
        _state.emit(state.value.copy(viewStatus = IDLE))
    }
}
