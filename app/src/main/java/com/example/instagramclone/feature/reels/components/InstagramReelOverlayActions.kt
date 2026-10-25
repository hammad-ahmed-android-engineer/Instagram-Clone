package com.example.instagramclone.feature.reels.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.instagramclone.core.designsystem.components.InstagramIcons
import com.example.instagramclone.core.designsystem.components.InstagramLikeButton
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.core.designsystem.theme.RedLike
import com.example.instagramclone.R

/**
 * Replicated directly from screenshot 3:
 * 1. Like (Heart) + "Likes" or count
 * 2. Comments + "326" count
 * 3. Repost (re-share loop) + "1,770" count
 * 4. Share (DM paper airplane) + "5,479" count
 * 5. Bookmark / Save + "2,658" count
 * 6. Options (3 dots / horizontal bars)
 * 7. Rotating music vinyl disc
 */
@Composable
fun InstagramReelOverlayActions(
    isLiked: Boolean,
    likesCount: Int,
    commentsCount: Int,
    onLikeClick: () -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier,
    repostCount: Int = 1770,
    saveCount: Int = 2658,
    audioCoverUrl: String? = null
) {
    val infiniteTransition = rememberInfiniteTransition(label = "discRotate")
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation"
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. Heart Like Button + Count/Likes
        InstagramLikeButton(
            isLiked = isLiked,
            onLikeClick = onLikeClick,
            size = AppDimensions.iconLarge,
            unlikedColor = Color.White,
            likedColor = RedLike
        )
        Text(
            text = if (likesCount > 0) (if (isLiked) "${likesCount + 1}" else "$likesCount") else "Likes",
            style = AppTypography.caption.copy(color = Color.White, fontSize = AppDimensions.textSmall),
            modifier = Modifier.padding(top = AppDimensions.spacingMicro)
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingMedium))

        // 2. Comment Button + Count
        Icon(
            imageVector = InstagramIcons.Comment,
            contentDescription = stringResource(id = R.string.cd_comments),
            tint = Color.White,
            modifier = Modifier
                .size(AppDimensions.iconLarge)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onCommentClick
                )
        )
        Text(
            text = "$commentsCount",
            style = AppTypography.caption.copy(color = Color.White, fontSize = AppDimensions.textSmall),
            modifier = Modifier.padding(top = AppDimensions.spacingMicro)
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingMedium))

        // 3. Repost Button + Count (as seen in screenshot 3)
        Icon(
            imageVector = InstagramIcons.Repost,
            contentDescription = stringResource(id = R.string.cd_share),
            tint = Color.White,
            modifier = Modifier
                .size(AppDimensions.iconMedium)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {}
                )
        )
        Text(
            text = "$repostCount",
            style = AppTypography.caption.copy(color = Color.White, fontSize = AppDimensions.textSmall),
            modifier = Modifier.padding(top = AppDimensions.spacingMicro)
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingMedium))

        // 4. Share (Paper Plane) + Count
        Icon(
            imageVector = InstagramIcons.Share,
            contentDescription = stringResource(id = R.string.cd_share),
            tint = Color.White,
            modifier = Modifier
                .size(AppDimensions.iconMedium)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onShareClick
                )
        )
        Text(
            text = "5,479",
            style = AppTypography.caption.copy(color = Color.White, fontSize = AppDimensions.textSmall),
            modifier = Modifier.padding(top = AppDimensions.spacingMicro)
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingMedium))

        // 5. Bookmark / Save + Count
        Icon(
            imageVector = Icons.Outlined.BookmarkBorder,
            contentDescription = stringResource(id = R.string.cd_save),
            tint = Color.White,
            modifier = Modifier
                .size(AppDimensions.iconMedium)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {}
                )
        )
        Text(
            text = "$saveCount",
            style = AppTypography.caption.copy(color = Color.White, fontSize = AppDimensions.textSmall),
            modifier = Modifier.padding(top = AppDimensions.spacingMicro)
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingMedium))

        // 6. More Options
        Icon(
            imageVector = Icons.Outlined.MoreHoriz,
            contentDescription = stringResource(id = R.string.cd_options),
            tint = Color.White,
            modifier = Modifier
                .size(AppDimensions.iconMedium)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {}
                )
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingMedium))

        // 7. Spinning Audio Vinyl Disc
        Box(
            modifier = Modifier
                .size(AppDimensions.iconLarge)
                .clip(RoundedCornerShape(AppDimensions.radiusSmall))
                .border(AppDimensions.borderMedium, Color.White, RoundedCornerShape(AppDimensions.radiusSmall)),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = audioCoverUrl ?: "https://picsum.photos/id/1015/100/100",
                contentDescription = stringResource(id = R.string.cd_audio_track),
                modifier = Modifier
                    .size(AppDimensions.iconMedium)
                    .clip(CircleShape)
                    .rotate(angle),
                contentScale = ContentScale.Crop
            )
        }
    }
}
