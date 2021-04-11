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

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.viewinterop.AndroidView
import com.pp.moviefy.presentation.auth.events.AuthViewEvent.Login
import com.pp.moviefy.presentation.auth.events.AuthViewEvent.RequestAuthorization
import com.pp.moviefy.presentation.auth.state.AuthViewStatus
import com.pp.moviefy.presentation.navigation.NavigationDirections
import com.pp.moviefy.presentation.navigation.NavigationManager
import com.pp.moviefy.presentation.utils.AUTHORIZATION_ENDPOINT
import com.pp.moviefy.presentation.utils.AUTHORIZED_REDIRECTION

@Composable
fun AuthScreen(viewModel: AuthViewModel) {
    val state by viewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        when (state.viewStatus) {
            AuthViewStatus.IDLE -> {
                Button(onClick = { viewModel.onEvent(RequestAuthorization) }) {
                    Text(text = "request authorization")
                }
            }
            AuthViewStatus.ERROR -> {
                Button(onClick = { viewModel.onEvent(RequestAuthorization) }) {
                    Text(text = "request authorization")
                }
            }
            AuthViewStatus.LOADING -> {
                Button(onClick = { viewModel.onEvent(RequestAuthorization) }) {
                    Text(text = "request authorization")
                }
            }
            AuthViewStatus.REQUESTING_AUTHORIZATION -> {
                RequestAuthorization(
                    requestToken = state.requestToken,
                    onSuccess = {
                        viewModel.onEvent(Login(state.requestToken))
                    },
                    onError = {
                    }
                )
            }
            AuthViewStatus.LOGGED_IN -> {
                NavigationManager.navigate(NavigationDirections.Home)
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RequestAuthorization(requestToken: String, onSuccess: () -> Unit, onError: () -> Unit) {
    val alpha by animateFloatAsState(targetValue = 1f, animationSpec = tween(400))

    AndroidView(
        modifier = Modifier
            .alpha(alpha)
            .fillMaxSize(),
        factory = {
            WebView(it).apply {
                loadUrl(AUTHORIZATION_ENDPOINT + requestToken)

                webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?
                    ): Boolean {
                        val url = request?.url?.toString()
                        val isAuthorized = url == AUTHORIZED_REDIRECTION

                        when (isAuthorized) {
                            true -> onSuccess()
                            false -> onError()
                        }

                        return isAuthorized
                    }
                }
            }
        }
    )
}
