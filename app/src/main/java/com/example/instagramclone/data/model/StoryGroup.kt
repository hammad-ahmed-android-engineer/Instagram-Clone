package com.example.instagramclone.data.model

data class StoryGroup(
    val author: User,
    val stories: List<Story>,
    val hasUnviewed: Boolean
)
