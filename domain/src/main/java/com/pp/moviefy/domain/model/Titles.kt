package com.pp.moviefy.domain.model

data class Titles(
    val id: Int,
    val titles: List<Title>,
    val success: Boolean
)

data class Title(
    val country: String,
    val title: String,
    val type: String
)
