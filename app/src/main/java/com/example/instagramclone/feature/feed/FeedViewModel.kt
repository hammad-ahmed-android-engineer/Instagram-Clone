package com.example.instagramclone.feature.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagramclone.data.model.Post
import com.example.instagramclone.data.model.StoryGroup
import com.example.instagramclone.data.repository.FeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedRepository: FeedRepository
) : ViewModel() {

    val posts: StateFlow<List<Post>> = feedRepository.posts
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val stories: StateFlow<List<StoryGroup>> = feedRepository.storyGroups
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun toggleLike(postId: String) {
        feedRepository.toggleLike(postId)
    }

    fun toggleSave(postId: String) {
        feedRepository.toggleSave(postId)
    }
}
