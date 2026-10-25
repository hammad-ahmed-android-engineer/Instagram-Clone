package com.example.instagramclone.data.repository

import com.example.instagramclone.data.model.Comment
import com.example.instagramclone.data.model.Post
import com.example.instagramclone.data.model.StoryGroup
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface FeedRepository {
    val posts: StateFlow<List<Post>>
    val storyGroups: StateFlow<List<StoryGroup>>
    
    fun toggleLike(postId: String)
    fun toggleSave(postId: String)
    fun addComment(postId: String, text: String, authorId: String)
    fun getCommentsForPost(postId: String): Flow<List<Comment>>
}
