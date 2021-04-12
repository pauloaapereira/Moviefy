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

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pp.moviefy.presentation.auth.components.RequestAuthorization
import com.pp.moviefy.presentation.auth.events.AuthViewEvent.Login
import com.pp.moviefy.presentation.auth.events.AuthViewEvent.RequestAuthorization
import com.pp.moviefy.presentation.auth.state.AuthViewStatus
import com.pp.moviefy.presentation.navigation.NavigationDirections
import com.pp.moviefy.presentation.navigation.NavigationManager

@Composable
fun AuthScreen(viewModel: AuthViewModel) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(state.viewStatus) {
        when (state.viewStatus) {
            AuthViewStatus.LOGGED_IN -> NavigationManager.navigate(NavigationDirections.Home)
            else -> {}
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { viewModel.onEvent(RequestAuthorization) }) {
            Text(text = "request authorization")
        }

        RequestAuthorization(
            state = state,
            onSuccess = {
                viewModel.onEvent(Login(state.requestToken))
            },
            onDismiss = {
            }
        )
    }
}
