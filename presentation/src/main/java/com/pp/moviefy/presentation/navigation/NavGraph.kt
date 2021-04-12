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
package com.pp.moviefy.presentation.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.pp.moviefy.presentation.auth.AuthScreen
import com.pp.moviefy.presentation.auth.AuthViewModel
import com.pp.moviefy.presentation.components.MoviefyPopup

@Composable
fun NavGraph(onDestinationChanged: (backgroundColor: Color) -> Unit = {}) {
    val navController = rememberNavController()

    NavigationManager.command.collectAsState().value.also { command ->
        if (command.destination.isNotEmpty()) {
            navController.navigate(command.destination)
            onDestinationChanged(command.backgroundColor)
        }
    }

    NavHost(
        navController,
        startDestination = NavigationDirections.Authentication.destination
    ) {
        composable(NavigationDirections.Authentication.destination) { backStackEntry ->
            val viewModel = hiltNavGraphViewModel<AuthViewModel>(backStackEntry = backStackEntry)
            AuthScreen(viewModel = viewModel)
        }
        composable(NavigationDirections.Home.destination) {
            MoviefyPopup(isVisible = true, title = "Home Popup", onDismiss = { /*TODO*/ }) {
                Text(text = "hola home")
            }
        }
    }
}
