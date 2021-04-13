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

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pp.design.small.button.Button
import com.pp.design.small.text.Text
import com.pp.moviefy.presentation.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun Actions(
    modifier: Modifier = Modifier,
    onEnterAsUserClick: () -> Unit = {},
    onEnterAsGuestClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text.HeaderThree(text = stringResource(id = R.string.app_name))
        Spacer(modifier = Modifier.size(48.dp))
        Button.Primary(text = stringResource(R.string.auth_enter_as_user)) {
            onEnterAsUserClick()
        }
        Spacer(modifier = Modifier.size(8.dp))
        Button.Primary(text = stringResource(R.string.auth_enter_as_guest)) {
            onEnterAsGuestClick()
        }
    }
}
