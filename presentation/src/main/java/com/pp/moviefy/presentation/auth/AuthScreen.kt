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

import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import com.pp.design.utils.animateFloatByBoolean
import com.pp.moviefy.presentation.auth.components.Actions
import com.pp.moviefy.presentation.auth.components.AuthorizationPopup
import com.pp.moviefy.presentation.auth.events.AuthViewEvent.DismissAuthorizationRequest
import com.pp.moviefy.presentation.auth.events.AuthViewEvent.Login
import com.pp.moviefy.presentation.auth.events.AuthViewEvent.RequestAuthorization
import com.pp.moviefy.presentation.auth.state.AuthViewStatus
import com.pp.moviefy.presentation.auth.state.AuthViewStatus.ADVANCING
import com.pp.moviefy.presentation.auth.state.AuthViewStatus.SUCCESSFULLY_LOGGED_IN
import com.pp.moviefy.presentation.auth.state.LoggedInTransitionDelay
import com.pp.moviefy.presentation.auth.state.LoggedInTransitionDuration
import com.pp.moviefy.presentation.navigation.NavigationDirections.Home
import com.pp.moviefy.presentation.navigation.NavigationManager.navigate

@Composable
fun AuthScreen(viewModel: AuthViewModel) {
    val state by viewModel.state.collectAsState()
    val loggedInTransition = updateTransition(
        targetState = state.viewStatus == SUCCESSFULLY_LOGGED_IN,
        label = "AuthLoggedInTransition"
    )

    LaunchedEffect(state.viewStatus) {
        if (state.viewStatus == ADVANCING)
            navigate(Home)
    }

    val actionsScale by loggedInTransition.animateFloatByBoolean(
        onTrue = 15f,
        onFalse = 1f,
        duration = LoggedInTransitionDuration,
        delay = LoggedInTransitionDelay
    )

    val actionsAlpha by loggedInTransition.animateFloatByBoolean(
        onTrue = 0f,
        onFalse = 1f,
        duration = LoggedInTransitionDuration,
        delay = LoggedInTransitionDelay
    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Actions(
            modifier = Modifier
                .scale(actionsScale)
                .alpha(actionsAlpha),
            onEnterAsUserClick = {
                viewModel.onEvent(RequestAuthorization)
            },
            onEnterAsGuestClick = {
            }
        )

        AuthorizationPopup(
            isVisible = state.requestToken.isNotEmpty() && state.viewStatus == AuthViewStatus.REQUESTING_AUTHORIZATION,
            requestToken = state.requestToken,
            onSuccess = {
                viewModel.onEvent(Login(state.requestToken))
            },
            onDismiss = {
                viewModel.onEvent(DismissAuthorizationRequest)
            }
        )
    }
}
