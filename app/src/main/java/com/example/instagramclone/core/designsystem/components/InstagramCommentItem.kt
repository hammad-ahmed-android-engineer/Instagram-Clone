package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle
import com.example.instagramclone.core.common.utils.DateTimeUtils
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.data.model.Comment

/**
 * Segregated Instagram comment row displaying avatar, annotated username + text,
 * timestamp, reply button, and animated like heart.
 * Scaled dynamically with AppDimensions.
 */
@Composable
fun InstagramCommentItem(
    comment: Comment,
    modifier: Modifier = Modifier
) {
    var isCommentLiked by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = AppDimensions.spacingSmall),
        verticalAlignment = Alignment.Top
    ) {
        UserAvatar(
            imageUrl = comment.author.profilePicUrl,
            size = AppDimensions.storyAvatarSmall,
            hasStory = false
        )
        Spacer(modifier = Modifier.width(AppDimensions.spacingMedium))
        Column(modifier = Modifier.weight(1f)) {
            val annotatedComment = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                ) {
                    append("${comment.author.username} ")
                }
                withStyle(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.onBackground
                    )
                ) {
                    append(comment.text)
                }
            }

            Text(
                text = annotatedComment,
                style = AppTypography.caption
            )

            Row(
                modifier = Modifier.padding(top = AppDimensions.spacingTiny),
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingDefault),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = DateTimeUtils.getRelativeTimeSpan(comment.timestamp),
                    style = AppTypography.timestamp
                )
                Text(
                    text = stringResource(id = com.example.instagramclone.R.string.comment_reply),
                    style = AppTypography.timestamp.copy(fontWeight = FontWeight.SemiBold)
                )
            }
        }

        // Comment Heart Like (using bouncy InstagramLikeButton)
        InstagramLikeButton(
            isLiked = isCommentLiked,
            onLikeClick = { isCommentLiked = !isCommentLiked },
            size = AppDimensions.badgeSize,
            unlikedColor = MaterialTheme.colorScheme.outline
        )
    }
}
