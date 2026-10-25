package com.example.instagramclone.data.model

data class Post(
    val id: String,
    val author: User,
    val imageUrls: List<String>,
    val caption: String,
    val likesCount: Int,
    val commentsCount: Int,
    val timestamp: Long,
    val isLiked: Boolean,
    val isSaved: Boolean
)
