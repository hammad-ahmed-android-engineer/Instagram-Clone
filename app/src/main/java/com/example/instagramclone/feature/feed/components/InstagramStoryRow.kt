package com.example.instagramclone.feature.feed.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.data.model.StoryGroup

/**
 * Replicated from CC-Instagram StoryUi.kt
 * Segregated InstagramStoryRow composing InstagramYourStoryItem and friend InstagramStoryItems.
 * Scaled dynamically with AppDimensions.
 */
@Composable
fun InstagramStoryRow(
    stories: List<StoryGroup>,
    onStoryClick: (StoryGroup) -> Unit = {},
    onYourStoryClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = AppDimensions.spacingMedium),
        horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingMedium),
        modifier = modifier.padding(vertical = AppDimensions.spacingSmall)
    ) {
        // First Item: "Your story" with blue "+" add badge
        item(key = "your_story") {
            InstagramYourStoryItem(onClick = onYourStoryClick)
        }

        // Friends' Stories
        items(stories, key = { it.author.id }) { storyGroup ->
            InstagramStoryItem(
                storyGroup = storyGroup,
                onClick = { onStoryClick(storyGroup) }
            )
        }
    }
}
