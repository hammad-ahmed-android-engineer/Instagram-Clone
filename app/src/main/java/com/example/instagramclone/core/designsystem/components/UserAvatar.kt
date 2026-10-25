package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.BluePrimary
import com.example.instagramclone.core.designsystem.theme.InstagramStoryBrush
import com.example.instagramclone.core.designsystem.theme.StoryViewedGrayDark
import com.example.instagramclone.core.designsystem.theme.StoryViewedGrayLight
import com.example.instagramclone.R

@Composable
fun UserAvatar(
    imageUrl: String,
    modifier: Modifier = Modifier,
    size: Dp = AppDimensions.profileAvatarMedium,
    hasStory: Boolean = false,
    isStoryViewed: Boolean = false,
    showAddBadge: Boolean = false,
    contentDescription: String? = null
) {
    val defaultCd = contentDescription ?: stringResource(id = R.string.cd_user_avatar)
    val isDark = isSystemInDarkTheme()
    val ringBrush: Brush? = when {
        !hasStory -> null
        isStoryViewed -> SolidColor(if (isDark) StoryViewedGrayDark else StoryViewedGrayLight)
        else -> InstagramStoryBrush
    }

    // Outer container
    Box(
        modifier = modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        if (ringBrush != null) {
            // Instagram outer colorful/gray gradient ring
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        width = if (size > AppDimensions.storyAvatarMedium) AppDimensions.borderThick else AppDimensions.borderMedium,
                        brush = ringBrush,
                        shape = CircleShape
                    )
            )
        }

        // Inner image with Instagram gap (padding from outer ring)
        val gapPadding = if (hasStory) (if (size > AppDimensions.storyAvatarMedium) AppDimensions.storyRingGap else AppDimensions.storyRingBorder) else AppDimensions.spacingZero

        AsyncImage(
            model = imageUrl,
            contentDescription = defaultCd,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .padding(gapPadding)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.background)
        )

        // Blue "+" badge for "Your Story"
        if (showAddBadge) {
            val badgeSize = (size * 0.28f).coerceAtLeast(AppDimensions.iconSmall)
            Box(
                modifier = Modifier
                    .size(badgeSize)
                    .align(Alignment.BottomEnd)
                    .offset(x = AppDimensions.borderThin, y = AppDimensions.borderThin)
                    .background(BluePrimary, CircleShape)
                    .border(AppDimensions.borderMedium, MaterialTheme.colorScheme.background, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.cd_add_to_story),
                    tint = Color.White,
                    modifier = Modifier.size(badgeSize * 0.7f)
                )
            }
        }
    }
}
