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
package com.pp.moviefy.domain.model

data class Videos(
    val id: Int,
    val networkVideos: List<Video>,
    val success: Boolean
)

data class Video(
    val id: String,
    val country: String,
    val language: String,
    val key: String,
    val name: String,
    val site: String,
    val size: Int,
    val type: VideoType
)

enum class VideoType(val id: String) {
    INVALID("Invalid"),
    TRAILER("Trailer"),
    TEASER("Teaser"),
    CLIP("Clip"),
    FEATURETTE("Featurette"),
    BEHIND_THE_SCENES("Behind the Scenes"),
    BLOOPERS("Bloopers")
}
