package com.example.instagramclone.feature.reels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.data.dummy.DummyData
import com.example.instagramclone.feature.reels.components.InstagramReelInfoOverlay
import com.example.instagramclone.feature.reels.components.InstagramReelOverlayActions
import com.example.instagramclone.feature.reels.components.InstagramReelsHeader

/**
 * Full-screen immersive Reels experience with 9:16 vertical video feed,
 * animated interactions, sound indicator, and landscape-adapted centered column.
 */
@Composable
fun ReelsScreen() {
    val sampleReels = DummyData.posts.take(4)
    val pagerState = rememberPagerState(pageCount = { sampleReels.size })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        VerticalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = AppDimensions.maxContentWidth)
        ) { page ->
            val reel = sampleReels[page]
            var isLiked by remember { mutableStateOf(false) }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ) {
                AsyncImage(
                    model = reel.imageUrls.firstOrNull(),
                    contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_reel_media),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Top "Reels" Header with camera icon
                InstagramReelsHeader(modifier = Modifier.align(Alignment.TopStart))

                // Right side overlay actions (Instagram heart, comment, share, more, vinyl)
                InstagramReelOverlayActions(
                    isLiked = isLiked,
                    likesCount = reel.likesCount,
                    commentsCount = reel.commentsCount,
                    onLikeClick = { isLiked = !isLiked },
                    onCommentClick = { /* Comments */ },
                    onShareClick = { /* Share */ },
                    audioCoverUrl = reel.author.profilePicUrl,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = AppDimensions.spacingMedium, bottom = AppDimensions.spacingLarge)
                )

                // Bottom Left author details and audio info
                InstagramReelInfoOverlay(
                    author = reel.author,
                    caption = reel.caption,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = AppDimensions.spacingMedium, bottom = AppDimensions.spacingLarge, end = AppDimensions.dp(76))
                )
            }
        }
    }
}
