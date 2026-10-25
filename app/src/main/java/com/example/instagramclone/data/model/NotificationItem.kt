package com.example.instagramclone.data.model

data class NotificationItem(
    val id: String,
    val type: String, // e.g., "LIKE", "COMMENT", "FOLLOW"
    val user: User,
    val message: String,
    val timestamp: Long,
    val isRead: Boolean,
    val postImageUrl: String? = null
)
