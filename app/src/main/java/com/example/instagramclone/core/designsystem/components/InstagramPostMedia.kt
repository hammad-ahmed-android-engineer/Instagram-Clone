package com.example.instagramclone.core.designsystem.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

/**
 * Replicated from CC-Instagram PostUi.kt
 * Renamed to InstagramPostMedia with double-tap heart burst animation.
 */
@Composable
fun InstagramPostMedia(
    imageUrl: String?,
    caption: String,
    onDoubleTap: () -> Unit,
    modifier: Modifier = Modifier
) {
    DoubleTapLikeOverlay(
        onDoubleTap = onDoubleTap,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = caption,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
