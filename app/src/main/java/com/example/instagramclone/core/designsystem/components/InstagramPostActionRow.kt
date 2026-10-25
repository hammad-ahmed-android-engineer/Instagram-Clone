package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.instagramclone.core.common.utils.NumberFormatUtils
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.R

/**
 * Replicated directly from real Instagram post action row:
 * - Like (Heart) + Like count next to it
 * - Comment + Comment count next to it
 * - Repost + Repost count next to it
 * - Share (DM paper airplane) + Share count next to it
 * - Bookmark (Save) on far right
 */
@Composable
fun InstagramPostActionRow(
    isLiked: Boolean,
    likesCount: Int,
    commentsCount: Int,
    onLikeClick: () -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSaved: Boolean = false,
    repostCount: Int = 0,
    shareCount: Int = 0,
    onRepostClick: () -> Unit = {}
) {
    val iconColor = MaterialTheme.colorScheme.onBackground
    val displayLikes = if (isLiked) likesCount + 1 else likesCount
    val displayReposts = if (repostCount > 0) repostCount else (commentsCount * 2 + 1).coerceAtLeast(1)
    val displayShares = if (shareCount > 0) shareCount else (likesCount / 25 + 4).coerceAtLeast(2)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = AppDimensions.spacingMedium,
                end = AppDimensions.spacingMedium,
                top = AppDimensions.spacingSmall,
                bottom = AppDimensions.spacingMicro
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Left group: Like + count, Comment + count, Repost + count, Share + count
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingMedium)
        ) {
            // 1. Like with count next to it
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onLikeClick
                )
            ) {
                InstagramLikeButton(
                    isLiked = isLiked,
                    onLikeClick = onLikeClick,
                    size = AppDimensions.iconMedium
                )
                if (displayLikes > 0) {
                    Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))
                    Text(
                        text = NumberFormatUtils.formatCompact(displayLikes),
                        style = AppTypography.caption.copy(
                            fontSize = AppDimensions.textSmall,
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = iconColor
                    )
                }
            }

            // 2. Comment with count next to it
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onCommentClick
                )
            ) {
                Icon(
                    imageVector = InstagramIcons.Comment,
                    contentDescription = stringResource(id = R.string.cd_comment),
                    tint = iconColor,
                    modifier = Modifier.size(AppDimensions.iconMedium)
                )
                if (commentsCount > 0) {
                    Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))
                    Text(
                        text = NumberFormatUtils.formatCompact(commentsCount),
                        style = AppTypography.caption.copy(
                            fontSize = AppDimensions.textSmall,
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = iconColor
                    )
                }
            }

            // 3. Repost with count next to it
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onRepostClick
                )
            ) {
                Icon(
                    imageVector = InstagramIcons.Repost,
                    contentDescription = stringResource(id = R.string.cd_share),
                    tint = iconColor,
                    modifier = Modifier.size(AppDimensions.iconMedium)
                )
                Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))
                Text(
                    text = NumberFormatUtils.formatCompact(displayReposts),
                    style = AppTypography.caption.copy(
                        fontSize = AppDimensions.textSmall,
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = iconColor
                )
            }

            // 4. Share with count next to it
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onShareClick
                )
            ) {
                Icon(
                    imageVector = InstagramIcons.Share,
                    contentDescription = stringResource(id = R.string.cd_share),
                    tint = iconColor,
                    modifier = Modifier.size(AppDimensions.iconMedium)
                )
                Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))
                Text(
                    text = NumberFormatUtils.formatCompact(displayShares),
                    style = AppTypography.caption.copy(
                        fontSize = AppDimensions.textSmall,
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = iconColor
                )
            }
        }

        // Right item: Bookmark / Save
        Icon(
            imageVector = if (isSaved) InstagramIcons.BookmarkFilled else InstagramIcons.Bookmark,
            contentDescription = stringResource(id = R.string.cd_save),
            tint = iconColor,
            modifier = Modifier
                .size(AppDimensions.iconMedium)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onSaveClick
                )
        )
    }
}
