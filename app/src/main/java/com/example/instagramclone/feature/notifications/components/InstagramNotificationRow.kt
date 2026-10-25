package com.example.instagramclone.feature.notifications.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle
import coil.compose.AsyncImage
import com.example.instagramclone.core.common.utils.DateTimeUtils
import com.example.instagramclone.core.designsystem.components.UserAvatar
import com.example.instagramclone.core.designsystem.dimensions.AppDimensions
import com.example.instagramclone.core.designsystem.theme.AppTypography
import com.example.instagramclone.core.designsystem.theme.BluePrimary
import com.example.instagramclone.data.model.NotificationItem

/**
 * Replicated from CC-Instagram Activity.kt (myui)
 * Renamed to InstagramNotificationRow with scalable AppDimensions sizing.
 */
@Composable
fun InstagramNotificationRow(
    item: NotificationItem,
    modifier: Modifier = Modifier
) {
    var isFollowing by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = AppDimensions.spacingMedium, vertical = AppDimensions.spacingSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        UserAvatar(
            imageUrl = item.user.profilePicUrl,
            size = AppDimensions.tabHeight,
            hasStory = true
        )
        Spacer(modifier = Modifier.width(AppDimensions.spacingMedium))

        val annotatedText = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            ) {
                append("${item.user.username} ")
            }
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onBackground
                )
            ) {
                append(item.message)
            }
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.outline,
                    fontSize = AppDimensions.textCaption
                )
            ) {
                append("  ${DateTimeUtils.getRelativeTimeSpan(item.timestamp)}")
            }
        }

        Text(
            text = annotatedText,
            style = AppTypography.caption,
            modifier = Modifier.weight(1f)
        )

        if (item.postImageUrl != null) {
            Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))
            AsyncImage(
                model = item.postImageUrl,
                contentDescription = stringResource(id = com.example.instagramclone.R.string.cd_post_thumbnail),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(AppDimensions.tabHeight)
                    .clip(RoundedCornerShape(AppDimensions.radiusMicro))
            )
        } else if (item.type == "follow") {
            Spacer(modifier = Modifier.width(AppDimensions.spacingSmall))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(AppDimensions.radiusSmall))
                    .background(if (isFollowing) MaterialTheme.colorScheme.surfaceVariant else BluePrimary)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = { isFollowing = !isFollowing }
                    )
                    .padding(horizontal = AppDimensions.spacingDefault, vertical = AppDimensions.spacingSmall),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (isFollowing) androidx.compose.ui.res.stringResource(id = com.example.instagramclone.R.string.reels_following) else androidx.compose.ui.res.stringResource(id = com.example.instagramclone.R.string.reels_follow),
                    style = AppTypography.buttonText.copy(
                        color = if (isFollowing) MaterialTheme.colorScheme.onBackground else Color.White,
                        fontSize = AppDimensions.textMedium
                    )
                )
            }
        }
    }
}
