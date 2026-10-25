package com.example.instagramclone.feature.profile.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import com.example.instagramclone.core.designsystem.components.InstagramIcons
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.data.model.Post
import com.example.instagramclone.R

/**
 * Segregated InstagramProfilePostGridItem displaying square post image:
 * - Optional reel badge in corner
 * - Views indicator with eye icon in bottom-left corner (as seen in screenshot 4)
 * - Scaled dynamically with AppDimensions.
 */
@Composable
fun InstagramProfilePostGridItem(
    post: Post,
    onPostClick: (Post) -> Unit,
    modifier: Modifier = Modifier
) {
    val isReel = post.id.hashCode() % 2 == 0
    val viewsCount = 30 + kotlin.math.abs(post.id.hashCode() % 15)

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clickable { onPostClick(post) }
    ) {
        AsyncImage(
            model = post.imageUrls.firstOrNull(),
            contentDescription = post.caption,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Top-right indicator
        if (isReel) {
            Icon(
                imageVector = InstagramIcons.Reels,
                contentDescription = stringResource(id = R.string.cd_reel),
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(AppDimensions.spacingTiny)
                    .size(AppDimensions.spacingMedium)
            )
        }

        // Bottom-left views metric indicator (as seen in screenshot 4: 👁 34)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(AppDimensions.spacingTiny)
        ) {
            Icon(
                imageVector = Icons.Outlined.Visibility,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(AppDimensions.spacingMedium)
            )
            Spacer(modifier = Modifier.width(AppDimensions.spacingMicro))
            Text(
                text = "$viewsCount",
                style = AppTypography.caption.copy(
                    color = Color.White,
                    fontSize = AppDimensions.textCaption,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}
