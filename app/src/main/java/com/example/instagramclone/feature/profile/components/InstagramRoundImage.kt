package com.example.instagramclone.feature.profile.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

/**
 * Replicated from CC-Instagram Profile.kt (RoundImage)
 * Renamed to InstagramRoundImage with scalable AppDimensions sizing.
 */
@Composable
fun InstagramRoundImage(
    image: Any?,
    modifier: Modifier = Modifier,
    borderColor: Color = MaterialTheme.colorScheme.outline,
    borderWidth: Dp = AppDimensions.borderThin,
    gapPadding: Dp = AppDimensions.storyRingGap
) {
    AsyncImage(
        model = image,
        contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_profile_avatar),
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = borderWidth,
                color = borderColor,
                shape = CircleShape
            )
            .padding(gapPadding)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}
