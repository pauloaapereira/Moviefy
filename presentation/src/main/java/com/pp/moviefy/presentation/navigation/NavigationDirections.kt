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

import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NamedNavArgument

object NavigationDirections {

    val Authentication = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()

        override val destination: String = "authentication"

        override val backgroundColor: Color = Color(0xFFd7d4c6)
    }

    val Home = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()

        override val destination: String = "home"

        override val backgroundColor: Color = Color(0xFF282b39)
    }
}
