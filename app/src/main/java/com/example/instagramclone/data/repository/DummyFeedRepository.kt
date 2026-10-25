package com.example.instagramclone.data.repository

import com.example.instagramclone.data.dummy.DummyData
import com.example.instagramclone.data.model.Comment
import com.example.instagramclone.data.model.Post
import com.example.instagramclone.data.model.StoryGroup
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@Singleton
class DummyFeedRepository @Inject constructor() : FeedRepository {
    private val _posts = MutableStateFlow(DummyData.posts)
    override val posts: StateFlow<List<Post>> = _posts.asStateFlow()

    private val _storyGroups = MutableStateFlow(DummyData.storyGroups)
    override val storyGroups: StateFlow<List<StoryGroup>> = _storyGroups.asStateFlow()

    private val _comments = MutableStateFlow(DummyData.comments)

    override fun toggleLike(postId: String) {
        _posts.update { currentPosts ->
            currentPosts.map { post ->
                if (post.id == postId) {
                    val newIsLiked = !post.isLiked
                    post.copy(
                        isLiked = newIsLiked,
                        likesCount = if (newIsLiked) post.likesCount + 1 else post.likesCount - 1
                    )
                } else {
                    post
                }
            }
        }
    }

    override fun toggleSave(postId: String) {
        _posts.update { currentPosts ->
            currentPosts.map { post ->
                if (post.id == postId) {
                    post.copy(isSaved = !post.isSaved)
                } else {
                    post
                }
            }
        }
    }

    override fun addComment(postId: String, text: String, authorId: String) {
        val author = DummyData.users.find { it.id == authorId } ?: return
        val newComment = Comment(
            id = UUID.randomUUID().toString(),
            postId = postId,
            author = author,
            text = text,
            timestamp = System.currentTimeMillis(),
            likesCount = 0,
            isLiked = false
        )
        
        _comments.update { it + newComment }
        
        _posts.update { currentPosts ->
            currentPosts.map { post ->
                if (post.id == postId) {
                    post.copy(commentsCount = post.commentsCount + 1)
                } else {
                    post
                }
            }
        }
    }

    override fun getCommentsForPost(postId: String): Flow<List<Comment>> {
        return _comments.map { comments -> 
            comments.filter { it.postId == postId } 
        }
    }
}
