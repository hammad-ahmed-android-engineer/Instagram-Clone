package com.example.instagramclone.data.model

data class Comment(
    val id: String,
    val postId: String,
    val author: User,
    val text: String,
    val timestamp: Long,
    val likesCount: Int,
    val isLiked: Boolean
)
