package com.example.instagramclone.feature.reels.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.example.instagramclone.core.designsystem.components.InstagramIcons
import com.example.instagramclone.core.designsystem.components.UserAvatar
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.data.model.User
import com.example.instagramclone.R

/**
 * Bottom-left overlay for Reels screen: author avatar, username, verified badge,
 * inline follow button, caption snippet, and audio track attribution.
 * Scaled dynamically with AppDimensions.
 */
@Composable
fun InstagramReelInfoOverlay(
    author: User,
    caption: String,
    modifier: Modifier = Modifier
) {
    var isFollowing by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        // Author row + Follow button
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            UserAvatar(
                imageUrl = author.profilePicUrl,
                size = AppDimensions.buttonSmallHeight,
                hasStory = true
            )
            Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))
            Text(
                text = author.username,
                style = AppTypography.username.copy(color = Color.White, fontWeight = FontWeight.Bold)
            )

            if (author.isVerified) {
                Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))
                Icon(
                    imageVector = InstagramIcons.VerifiedBadge,
                    contentDescription = stringResource(id = R.string.cd_verified),
                    tint = Color.Unspecified,
                    modifier = Modifier.size(AppDimensions.iconTiny)
                )
            }

            Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))

            // Instagram Follow Button
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(AppDimensions.radiusSmall))
                    .border(AppDimensions.borderThin, Color.White.copy(alpha = 0.8f), RoundedCornerShape(AppDimensions.radiusSmall))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = { isFollowing = !isFollowing }
                    )
                    .padding(horizontal = AppDimensions.spacingSmall, vertical = AppDimensions.spacingMicro),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (isFollowing) stringResource(id = R.string.reels_following) else stringResource(id = R.string.reels_follow),
                    style = AppTypography.caption.copy(
                        color = Color.White,
                        fontSize = AppDimensions.textSmall,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(AppDimensions.spacingSmall))

        // Caption
        Text(
            text = caption,
            style = AppTypography.caption.copy(color = Color.White),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingSmall))

        // Music note + Audio track
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.MusicNote,
                contentDescription = stringResource(id = R.string.cd_audio),
                tint = Color.White,
                modifier = Modifier.size(AppDimensions.iconSmall)
            )
            Spacer(modifier = Modifier.width(AppDimensions.spacingTiny))
            Text(
                text = stringResource(id = R.string.reels_original_audio, author.username),
                style = AppTypography.timestamp.copy(color = Color.White, fontSize = AppDimensions.textSmall),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
