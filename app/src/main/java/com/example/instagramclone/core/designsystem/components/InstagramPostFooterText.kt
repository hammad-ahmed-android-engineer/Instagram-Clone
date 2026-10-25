package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle
import com.example.instagramclone.core.common.utils.DateTimeUtils
import com.example.instagramclone.core.common.utils.NumberFormatUtils
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.data.model.Post
import com.example.instagramclone.R

/**
 * Replicated from CC-Instagram PostUi.kt (PostFooterTextSection)
 * Renamed to InstagramPostFooterText with scalable AppDimensions sizing.
 */
@Composable
fun InstagramPostFooterText(
    post: Post,
    onCommentClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.padding(horizontal = AppDimensions.spacingMedium)
    ) {
        // Caption with inline Bold Username and blue hashtags/mentions
        val annotatedCaption = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            ) {
                append("${post.author.username} ")
            }

            // Parse caption tokens for #hashtag and @mention highlighting
            val words = post.caption.split(" ")
            words.forEachIndexed { index, word ->
                if (word.startsWith("#") || word.startsWith("@")) {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Normal,
                            color = com.example.instagramclone.core.designsystem.theme.BluePrimary
                        )
                    ) {
                        append(word)
                    }
                } else {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    ) {
                        append(word)
                    }
                }
                if (index < words.size - 1) append(" ")
            }
        }

        Column(modifier = Modifier.padding(top = AppDimensions.spacingMicro)) {
            Text(
                text = annotatedCaption,
                style = AppTypography.caption.copy(fontSize = AppDimensions.textSmall),
                maxLines = if (isExpanded) Int.MAX_VALUE else 2
            )
            if (post.caption.length > 60 && !isExpanded) {
                Text(
                    text = stringResource(id = R.string.post_more_caption),
                    style = AppTypography.timestamp,
                    modifier = Modifier
                        .padding(top = AppDimensions.spacingMicro)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = { isExpanded = true }
                        )
                )
            }
        }

        // Comments Count Link ("View all 2 comments")
        if (post.commentsCount > 0) {
            Text(
                text = stringResource(id = R.string.post_view_comments, post.commentsCount),
                style = AppTypography.timestamp,
                modifier = Modifier
                    .padding(vertical = AppDimensions.spacingMicro)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = onCommentClick
                    )
            )
        }

        // Timestamp ("11 hours ago")
        Text(
            text = DateTimeUtils.getRelativeTimeSpan(post.timestamp),
            style = AppTypography.timestamp,
            modifier = Modifier.padding(vertical = AppDimensions.spacingMicro)
        )
    }
}
