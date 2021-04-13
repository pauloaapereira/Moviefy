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
package com.pp.moviefy.presentation.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pp.design.background.LocalBaseColor
import com.pp.design.core.animation.MaxAnimationDuration
import com.pp.design.core.animation.MinAnimationDuration
import com.pp.design.small.icon.Icon
import com.pp.design.small.text.Text
import com.pp.design.utils.SurfaceBorder
import com.pp.design.utils.SurfaceShape
import com.pp.design.utils.animateDpByBoolean
import com.pp.design.utils.animateFloatByBoolean
import com.pp.moviefy.presentation.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MoviefyPopup(
    isVisible: Boolean,
    title: String,
    onDismiss: () -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
    val transition = updateTransition(targetState = isVisible, label = "MoviefyPopupTransition")

    val scrimAlpha by transition.animateFloatByBoolean(
        onTrue = .25f,
        onFalse = 0f,
        duration = MaxAnimationDuration
    )

    val popupOffset by transition.animateDpByBoolean(
        onTrue = 0.dp,
        onFalse = 400.dp,
        duration = MinAnimationDuration * 2
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .alpha(scrimAlpha)
            .background(Color.Black)
            .then(
                if (isVisible) {
                    Modifier.pointerInput(Unit) {
                        detectTapGestures {
                            onDismiss()
                        }
                    }
                } else Modifier
            )
    )

    BoxWithConstraints(modifier = Modifier.fillMaxSize().offset(x = popupOffset), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .fillMaxWidth(.8f)
                .heightIn(0.dp, maxHeight * .8f)
                .clip(SurfaceShape)
                .border(SurfaceBorder, SurfaceShape)
                .background(LocalBaseColor.current)
                .animateContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text.HeaderSix(
                    text = title
                )
                Icon.Button(
                    modifier = Modifier.padding(top = 4.dp),
                    icon = Icons.Filled.Clear,
                    contentDescription = stringResource(id = R.string.close_popup, title)
                ) {
                    onDismiss()
                }
            }
            Box(contentAlignment = Alignment.Center) {
                content()
            }
        }
    }
}
