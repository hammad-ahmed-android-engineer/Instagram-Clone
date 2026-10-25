package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.data.model.Post

/**
 * Replicated from CC-Instagram PostUi.kt (PostView)
 * Renamed to InstagramPostCard composing cleanly segregated sub-components with AppDimensions sizing.
 */
@Composable
fun InstagramPostCard(
    post: Post,
    onLikeClick: () -> Unit,
    onSaveClick: () -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = AppDimensions.spacingMedium)
    ) {
        // 1. Post Header (segregated in InstagramPostHeader.kt)
        InstagramPostHeader(
            author = post.author,
            onOptionsClick = {}
        )

        // 2. Post Media with Double-Tap Heart Burst Overlay (segregated in InstagramPostMedia.kt)
        InstagramPostMedia(
            imageUrl = post.imageUrls.firstOrNull(),
            caption = post.caption,
            onDoubleTap = {
                if (!post.isLiked) {
                    onLikeClick()
                }
            }
        )

        // 3. Post Action Row: Like, Comment, Repost, Share with counts, Bookmark (segregated in InstagramPostActionRow.kt)
        InstagramPostActionRow(
            isLiked = post.isLiked,
            likesCount = post.likesCount,
            commentsCount = post.commentsCount,
            isSaved = post.isSaved,
            onLikeClick = onLikeClick,
            onCommentClick = onCommentClick,
            onShareClick = onShareClick,
            onSaveClick = onSaveClick
        )

        // 4. Post Footer Text Section: Likes, Caption, Comments link, Timestamp (segregated in InstagramPostFooterText.kt)
        InstagramPostFooterText(
            post = post,
            onCommentClick = onCommentClick
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingSmall))

        // Hairline Divider between posts (matching CC-Instagram Divider)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppDimensions.dividerThickness)
                .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.5f))
        )
    }
}
