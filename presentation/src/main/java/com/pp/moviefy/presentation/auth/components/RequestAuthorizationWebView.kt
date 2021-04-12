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
package com.pp.moviefy.presentation.auth.components

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.pp.moviefy.presentation.auth.state.AuthViewState
import com.pp.moviefy.presentation.auth.state.AuthViewStatus.REQUESTING_AUTHORIZATION
import com.pp.moviefy.presentation.components.MoviefyPopup
import com.pp.moviefy.presentation.utils.AUTHORIZATION_ENDPOINT
import com.pp.moviefy.presentation.utils.AUTHORIZED_REDIRECTION

@SuppressLint("SetJavaScriptEnabled")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RequestAuthorization(
    state: AuthViewState,
    onSuccess: () -> Unit,
    onDismiss: () -> Unit
) {
    var isPageLoaded by remember { mutableStateOf(false) }

    MoviefyPopup(
        isVisible = state.requestToken.isNotEmpty() && state.viewStatus == REQUESTING_AUTHORIZATION,
        title = "Authorize your account",
        onDismiss = onDismiss
    ) {
        if (!isPageLoaded) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp), color = Color.Black)
        }
        AndroidView(
            factory = {
                WebView(it).apply {
                    loadUrl(AUTHORIZATION_ENDPOINT + state.requestToken)

                    settings.javaScriptEnabled = true
                    webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(
                            view: WebView?,
                            request: WebResourceRequest?
                        ): Boolean {
                            val url = request?.url?.toString()
                            val isAuthorized = url == AUTHORIZED_REDIRECTION

                            if (isAuthorized) {
                                onSuccess()
                            }

                            return isAuthorized
                        }

                        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                            super.onPageStarted(view, url, favicon)
                            isPageLoaded = false
                        }

                        override fun onPageFinished(view: WebView?, url: String?) {
                            super.onPageFinished(view, url)
                            isPageLoaded = true
                        }
                    }
                }
            }
        )
    }
}
