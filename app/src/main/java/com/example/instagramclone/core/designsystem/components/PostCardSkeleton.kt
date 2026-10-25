package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Modifier
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions

/**
 * Segregated PostCardSkeleton placeholder shimmering state when loading feed items.
 * Uses scalable AppDimensions sizing and AppDimensions tokens.
 */
@Composable
fun PostCardSkeleton(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = AppDimensions.spacingMedium)
    ) {
        // Author Header Skeleton
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = AppDimensions.spacingMedium,
                    vertical = AppDimensions.spacingSmall
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(AppDimensions.profileAvatarSmall)
                    .clip(CircleShape)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))
            Box(
                modifier = Modifier
                    .width(AppDimensions.likeOverlayHeart)
                    .height(AppDimensions.badgeSize)
                    .clip(RoundedCornerShape(AppDimensions.radiusSmall))
                    .shimmerEffect()
            )
        }

        // Post Image Media Skeleton
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shimmerEffect()
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingSmall))

        // Caption Lines Skeleton
        Column(modifier = Modifier.padding(horizontal = AppDimensions.spacingMedium)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(AppDimensions.spacingMedium)
                    .clip(RoundedCornerShape(AppDimensions.radiusSmall))
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(AppDimensions.spacingTiny))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .height(AppDimensions.spacingMedium)
                    .clip(RoundedCornerShape(AppDimensions.radiusSmall))
                    .shimmerEffect()
            )
        }
    }
}
