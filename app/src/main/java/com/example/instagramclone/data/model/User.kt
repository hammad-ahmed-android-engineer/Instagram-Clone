package com.example.instagramclone.data.model

data class User(
    val id: String,
    val username: String,
    val fullName: String,
    val profilePicUrl: String,
    val isVerified: Boolean
)
