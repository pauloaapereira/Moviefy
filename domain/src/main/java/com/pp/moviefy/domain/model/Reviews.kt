package com.pp.moviefy.domain.model

import org.threeten.bp.LocalDateTime

data class Reviews(
    val id: Int,
    val page: Int,
    val reviews: List<Review>,
    val totalPages: Int,
    val totalResults: Int,
    val success: Boolean
)

data class Review(
    val author: String,
    val authorDetails: AuthorDetails,
    val content: String,
    val createdAt: LocalDateTime,
    val id: String,
    val updatedAt: LocalDateTime,
    val url: String
)

data class AuthorDetails(
    val avatarPath: String,
    val name: String,
    val rating: Int,
    val username: String
)
