package com.example.instagramclone.feature.explore.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.instagramclone.core.designsystem.components.InstagramIcons
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.data.model.Post

/**
 * Segregated Instagram explore grid thumbnail with square aspect ratio,
 * reels/video overlay badge, and AppDimensions scaling.
 */
@Composable
fun InstagramExploreGridItem(
    post: Post,
    modifier: Modifier = Modifier,
    onClick: (Post) -> Unit = {}
) {
    val imageUrl = post.imageUrls.firstOrNull()

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable { onClick(post) }
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = post.caption,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Reels badge in top-right corner for video posts
        if (post.id.hashCode() % 2 == 0) {
            Icon(
                imageVector = InstagramIcons.Reels,
                contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_reel),
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(AppDimensions.spacingMicro)
                    .size(AppDimensions.iconSmall)
            )
        }
    }
}
