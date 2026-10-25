package com.example.instagramclone.data.model

data class SuggestedAccount(
    val id: String,
    val username: String,
    val fullName: String,
    val avatarUrl: String,
    val subtitle: String,
    val isVerified: Boolean = false,
    val isFollowing: Boolean = false
)
