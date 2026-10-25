package com.example.instagramclone

import com.example.instagramclone.data.repository.DummyFeedRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FeedRepositoryTest {

    private lateinit var repository: DummyFeedRepository

    @Before
    fun setUp() {
        repository = DummyFeedRepository()
    }

    @Test
    fun toggleLike_updatesPostState() = runBlocking {
        val initialPosts = repository.posts.first()
        val firstPost = initialPosts.first()
        val initialLiked = firstPost.isLiked
        val initialLikesCount = firstPost.likesCount

        repository.toggleLike(firstPost.id)

        val updatedPosts = repository.posts.first()
        val updatedPost = updatedPosts.first { it.id == firstPost.id }

        assertEquals(!initialLiked, updatedPost.isLiked)
        assertEquals(
            if (!initialLiked) initialLikesCount + 1 else initialLikesCount - 1,
            updatedPost.likesCount
        )
    }

    @Test
    fun toggleSave_updatesPostState() = runBlocking {
        val initialPosts = repository.posts.first()
        val firstPost = initialPosts.first()
        val initialSaved = firstPost.isSaved

        repository.toggleSave(firstPost.id)

        val updatedPosts = repository.posts.first()
        val updatedPost = updatedPosts.first { it.id == firstPost.id }

        assertEquals(!initialSaved, updatedPost.isSaved)
    }
}
