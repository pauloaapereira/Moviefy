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