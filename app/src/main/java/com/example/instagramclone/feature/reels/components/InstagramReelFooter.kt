package com.example.instagramclone.feature.reels.components

import androidx.compose.foundation.background
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.data.model.Post
import com.example.instagramclone.R

/**
 * Replicated from CC-Instagram Reels.kt (ReelFooter)
 * Renamed to InstagramReelFooter with scalable AppDimensions sizing.
 */
@Composable
fun InstagramReelFooter(
    post: Post,
    onLikeClick: () -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = AppDimensions.spacingSmall, vertical = AppDimensions.spacingMedium),
        verticalArrangement = Arrangement.Center
    ) {
        // User info row (Avatar, Username, White dot, "Follow")
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = post.author.profilePicUrl,
                contentDescription = stringResource(id = R.string.cd_reel_author),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(AppDimensions.iconLarge)
                    .clip(CircleShape)
                    .background(Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))
            Text(
                text = post.author.username,
                color = Color.White,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = AppDimensions.textMedium
                )
            )
            Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))
            Canvas(modifier = Modifier.size(AppDimensions.spacingTiny), onDraw = {
                drawCircle(
                    color = Color.White,
                    radius = 4f
                )
            })
            Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))
            Text(
                text = stringResource(id = R.string.reels_follow),
                color = Color.White,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = AppDimensions.textMedium
                ),
                modifier = Modifier.clickable { /* follow */ }
            )
        }

        Spacer(modifier = Modifier.height(AppDimensions.spacingMedium))

        // Post description/caption
        Text(
            text = post.caption,
            color = Color.White,
            style = MaterialTheme.typography.bodySmall.copy(fontSize = AppDimensions.textSmall)
        )

        Spacer(modifier = Modifier.height(AppDimensions.spacingSmall))

        // Audio Info
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            InstagramReelAction(
                imageVector = Icons.Default.MusicNote,
                contentDescription = stringResource(id = R.string.cd_audio)
            )
            Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))
            Text(
                text = stringResource(id = R.string.reels_original_audio, post.author.username),
                color = Color.White,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = AppDimensions.textSmall)
            )
        }

        Spacer(modifier = Modifier.height(AppDimensions.spacingMedium))

        // Actions row (Likes, Comments, Share, Bookmark, More)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingDefault)
            ) {
                InstagramReelActionMetric(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    text = "${post.likesCount}",
                    contentDescription = stringResource(id = R.string.cd_like),
                    onClick = onLikeClick
                )
                InstagramReelActionMetric(
                    imageVector = Icons.Outlined.ChatBubbleOutline,
                    text = "${post.commentsCount}",
                    contentDescription = stringResource(id = R.string.cd_comment),
                    onClick = onCommentClick
                )
                InstagramReelAction(
                    imageVector = Icons.AutoMirrored.Outlined.Send,
                    contentDescription = stringResource(id = R.string.cd_share),
                    onClick = onShareClick
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingDefault)
            ) {
                InstagramReelAction(
                    imageVector = Icons.Outlined.BookmarkBorder,
                    contentDescription = stringResource(id = R.string.cd_save)
                )
                InstagramReelAction(
                    imageVector = Icons.Outlined.MoreVert,
                    contentDescription = stringResource(id = R.string.cd_options)
                )
            }
        }
    }
}
