package com.pp.moviefy.domain.model

data class Images(
    val backdrops: List<Image>,
    val id: Int,
    val posters: List<Image>,
    val success: Boolean
)

data class Image(
    val aspectRatio: Double,
    val filePath: String,
    val height: Int,
    val language: String,
    val voteAverage: Double,
    val voteCount: Int,
    val width: Int
)
