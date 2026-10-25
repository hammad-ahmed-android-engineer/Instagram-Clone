package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.InstagramSunsetColors

/**
 * Replicated from CC-Instagram StoryUi.kt
 * Renamed to InstagramStoryImage with scalable AppDimensions sizing.
 */
@Composable
fun InstagramStoryImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    size: Dp = AppDimensions.storyAvatarMedium
) {
    val shape = CircleShape
    Box(
        modifier = modifier
            .diagonalGradientBorder(
                colors = InstagramSunsetColors,
                shape = shape,
                isFromRight = true
            )
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .padding(AppDimensions.storyRingGap)
                .background(color = MaterialTheme.colorScheme.surfaceVariant, shape = shape)
                .clip(shape)
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_story_avatar),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}
