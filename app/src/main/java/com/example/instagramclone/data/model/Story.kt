package com.example.instagramclone.data.model

data class Story(
    val id: String,
    val author: User,
    val imageUrl: String,
    val timestamp: Long,
    val isViewed: Boolean
)
